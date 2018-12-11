package chris.dream.dp;

/**
 * @author Chris
 * @describe: <p>建造者模式</p>
 * @date 上午 11:00 2018-08-14
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Student student = new Student.StudentBuilder().setId(1).setAge(18).setGender(1).setGrade(5).setName("牛三猫").build();
        System.out.println(student);
    }
}
