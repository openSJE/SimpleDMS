package com.example.simpledms.controller;

import com.example.simpledms.dto.gallery.ResponseGalleryDto;
import com.example.simpledms.dto.gallery.ResponseMessageDto;
import com.example.simpledms.model.Gallery;
import com.example.simpledms.service.GalleryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Dept07Controller
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 쿼리 메소드
 * 요약 :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class GalleryController {

    @Autowired
    GalleryService galleryService;

    //  Model to Dto 자동변환, Dto to Model 자동변환 외부 라이브러리
    ModelMapper modelMapper = new ModelMapper();

    //    이미지 업로드 컨트롤러 함수
    @PostMapping("/gallery/upload")
    public ResponseEntity<Object> galleryUploadFile(@RequestParam("galleryTitle") String galleryTitle,
                                                   @RequestParam("galleryFileName") String galleryFileName,
                                                   @RequestParam("gallery") MultipartFile gallery
    ) {

        String message = ""; // front-end 전송할 메세지

//            디버깅 출력
        log.debug("galleryTitle :" + galleryTitle);
        log.debug("galleryFileName :" + galleryFileName);
        log.debug("gallery :" + gallery);

        try {
//            db 저장 함수 호출
            galleryService.store(galleryTitle, galleryFileName, gallery);

            message = "Upload the file successfully: " + gallery.getOriginalFilename();

            return new ResponseEntity<>(new ResponseMessageDto(message), HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            message = "Could not upload the file : " + gallery.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessageDto(message),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    모든 이미지 정보 가져오기 함수
    @GetMapping("/gallery")
    public ResponseEntity<Object> getListFiles(@RequestParam(required = false) String galleryTitle,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size
    ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//          Upload 이미지 정보를 가져오는 함수
            Page<ResponseGalleryDto> galleryPage = galleryService
                    .findAllBygalleryTitleContaining(galleryTitle, pageable)
                    .map(gallery -> {
//                      자동적으로 반복문이 실행됨 : .map()
//                      1) 다운로드 URL 만들기
//          ServletUriComponentsBuilder : URL 만들어 주는 클래스
                        String fileDownloadUri = ServletUriComponentsBuilder
//                                (변경)
//                               .fromCurrentRequest() -> .fromCurrentContextPath()
                                .fromCurrentContextPath() // 이미지 파일 경로
                                .path("/api/gallery/")
                                .path(gallery.getGid().toString()) // "/api/gallery/1"
                                .toUriString(); // 마지막에 호출( URL 완성됨 )

//                      modelMapper 로 dbFile == fileDB -> ResponseFileDto 변환
//                        modelMapper.map(소스모델, 타겟DTO.class)
                        ResponseGalleryDto galleryDto = modelMapper.map(gallery, ResponseGalleryDto.class);

//                      DTO 에 2개 남은 속성 처리 : setter 이용 가공된 데이터 저장
                        galleryDto.setGallerySize(gallery.getGalleryData().length);
                        galleryDto.setGalleryUrl(fileDownloadUri);

                        return galleryDto;
                    });

//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("gallery", galleryPage.getContent());
            response.put("currentPage", galleryPage.getNumber());
            response.put("totalItems", galleryPage.getTotalElements());
            response.put("totalPages", galleryPage.getTotalPages());

            if (galleryPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    파일 다운로드 함수 : url /api/gallery/1
    @GetMapping("/gallery/{gid}")
    public ResponseEntity<byte[]> getFile(@PathVariable int gid) {

//        id 로 조회 함수
        Gallery gallery = galleryService.getGallery(gid).get();

//        첨부파일 다운로드 : url Content-Type 규칙
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + gallery.getGalleryTitle() + "\"")
                .body(gallery.getGalleryData());
    }

    //    id 삭제 함수
    @DeleteMapping("/gallery/deletion/{gid}")
    public ResponseEntity<Object> deleteGallery(@PathVariable int id) {

        try {
            boolean bSuccess = galleryService.removeById(id);

            if (bSuccess == true) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}








