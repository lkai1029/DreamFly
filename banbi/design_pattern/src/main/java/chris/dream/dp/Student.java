package chris.dream.dp;

import com.alibaba.fastjson.JSON;

import java.util.Objects;

/**
 * @author Chris
 * @description: <p>使用“建造者模式”创建的实体</p>
 *      解决问题：
 *          如果某实体包含n多属性，不同场景可能需要构建包含1、2、3...个属性的实体，需要编写n多构造方法以创建实例。
 *          使用建造者模式，可以解决这个问题。
 * @date 上午 11:02 2018-08-14
 */
public class Student {
    private int id;
    private String name;
    /**
     * 1:男；0:女
     */
    private int gender = 1;
    private int age = -1;
    private int grade = -1;

    public Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.gender = studentBuilder.gender;
        this.age = studentBuilder.age;
        this.grade = studentBuilder.grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id &&
                gender == student.gender &&
                age == student.age &&
                grade == student.grade &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age, grade);
    }

    /**
     * 实体建造者:
     *     包含的属性与实体对应，可用set方法进行构建，然后build生成实体
     */
    static class StudentBuilder{
        private int id;
        private String name;
        /**
         * 1:男；0:女
         */
        private int gender = 1;
        private int age = -1;
        private int grade = -1;

        /**
         * 注意这里返回的是StudentBuilder
         * @param id
         * @return
         */
        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setGender(int gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}

