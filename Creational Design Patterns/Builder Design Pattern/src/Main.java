public class Main {
    public static void main(String[] args) {

        // Builder Design Pattern :- Separate the construction of a complex object
        //                           from its representation so that the same construction processes can create different representations
        // or
        // Build complex objects step by step

        Student student =  Student.builder()
                .setId(1)
                .setName("mahmoud mohamed matar")
                .setPhone("+201128673348")
                .setGpa(3.1)
                .build();

        System.out.println(student.getId());
        System.out.println(student.getStudentName());
        System.out.println(student.getPhone());
        System.out.println(student.getGpa());

    }
}