package bean;
/**
 * @Description Customer为实体对象，用于封装客户信息
 * @author zhengyiyi
 * @date 2022年9月5日上午8:30
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Customer (){

    }

    public Customer (String name, char gender, int age, String phone, String email){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
}
