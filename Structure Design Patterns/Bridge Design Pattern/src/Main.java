import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //example :
        // لو عندي اتنين دكاتره كل واحد فيهم عنده عياده خاصه بيه بس ممكن الدكتور الاول انه يبعت مرضى لدكتور التاني والعكس صحيح ف يوجد بينها علاقه مع ان كل واحد فيهم شغال في العياده الخاصه به

        //when to use :
        //  - Divide large class into two separate hierarchies
        //  - Switching from inheritance to composition
        //  - Multiplatform support ( switching impl at run time )


        WindowsOS windowOS=new WindowsOS();
        Button button=new Button(windowOS);
        button.click();

        System.out.println("==================");

        button.os=new LinuxOS();
        button.click();


    }
}