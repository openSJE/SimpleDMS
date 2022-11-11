package sec02.exam02;

/**
 * packageName : sec02.exam02
 * fileName : FieldApplication
 * author : ds
 * date : 2022-09-27
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-09-27         ds          최초 생성
 */
public class FieldApplication {
    public static void main(String[] args) {
        FieldInit fieldInit = new FieldInit();

        System.out.println(fieldInit.booleanField);
        System.out.println(fieldInit.charField);

        System.out.println(fieldInit.doubleField);
        System.out.println(fieldInit.floatField);

        System.out.println(fieldInit.byteField);
        System.out.println(fieldInit.shortField);
        System.out.println(fieldInit.intField);
        System.out.println(fieldInit.lognField);


        System.out.println(fieldInit.arrField);
        System.out.println(fieldInit.stringField);
    }
}
