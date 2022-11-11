package com.example.simpledms.service;

import com.example.simpledms.model.Gallery;
import com.example.simpledms.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : DeptService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class GalleryService {

    @Autowired
    GalleryRepository galleryRepository; // JPA CRUD 함수가 있는 인터페이스

    //    모든 파일 조회
    public Page<Gallery> findAllGallery(Pageable pageable) {
        Page<Gallery> page = galleryRepository.findAll(pageable);

        return page;
    }

    //    ID(기본키)로 파일 조회( findById(기본키) : JPA 제공하는 기본 함수)
    public Optional<Gallery> getGallery(int gid) {
        Optional<Gallery> optionalGallery = galleryRepository.findById(gid);

        return optionalGallery;
    }


    //    fileTitle(이미지명) Like 검색하는 함수
    public Page<Gallery> findAllBygalleryTitleContaining(String galleryTitle, Pageable pageable) {
        Page<Gallery> page = galleryRepository
                .findAllBygalleryTitleContaining(galleryTitle, pageable);

        return page;
    }


    //    ID(기본키)로 삭제 함수 : 1건만 삭제됨
    public boolean removeById(int id) {

        if (galleryRepository.existsById(id) == true) {
            galleryRepository.deleteById(id); // 삭제 실행
            return true;
        }
        return false;
    }

    //    이미지 저장 함수(*)
    public Gallery store(String galleryTitle,
                        String galleryFileName,
                        MultipartFile gallery) throws IOException
    {
//        path(폴더경로) 제거 후 순수한 fileName 가져오기
//        .getOriginalFilename() : 경로/파일명
        String fileName = StringUtils.cleanPath(gallery.getOriginalFilename());

//        1) gallery 생성자에 경로 등 여러정보를 저장
        Gallery gallery2 = new Gallery(galleryTitle,
                                   galleryFileName,
                gallery.getContentType(), // 이미지의 타입정보( .jpg, .png 등 )
                gallery.getBytes());      // 이미지 크기(SIZE)

//        2) 위의 gallery 을 DB저장

        return galleryRepository.save(gallery2);
    }

}









