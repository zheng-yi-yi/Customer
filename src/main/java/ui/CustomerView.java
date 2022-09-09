package ui;
import bean.Customer;
import service.CustomerList;
import util.CMUtility;

/**
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * @author zhengyiyi
 * @date 2022年9月5日上午8:30
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer cust = new Customer("张三", '男', 30, "11111111111","abc@email.com");
        customerList.addCustomer(cust);
    }

    /**
     * @Description 显示《客户信息管理软件》界面
     */
    public void enterMainMenu(){
        boolean isFlag = true;
        while(isFlag){
            System.out.println("|====================================|");
            System.out.println("|------------客户信息管理软件----------|");
            System.out.println("|====================================|");
            System.out.println("|--------------1.添加客户-------------|");
            System.out.println("|--------------2.修改客户-------------|");
            System.out.println("|--------------3.删除客户-------------|");
            System.out.println("|--------------4.客户列表-------------|");
            System.out.println("|---------------5. 退出--------------|");
            System.out.println("|====================================|");
            System.out.print("请输入您的选择：");

            char menu = CMUtility.readMenuSelection();

            switch (menu) {
                case '1' -> addNewCustomer();
                case '2' -> modifyCustomer();
                case '3' -> deleteCustomer();
                case '4' -> listAllCustomer();
                case '5' -> {
                    System.out.print("请确认是否要退出（Y/N）：");
                    char c = CMUtility.readConfirmSelection();
                    if (c == 'Y') {
                        isFlag = false;
                    }
                }
            }
        }
    }
    /**
     * @Description 添加客户操作
     */
    private void addNewCustomer(){
        System.out.println("------------------------添加客户------------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess) {
            System.out.println("------------------------添加成功------------------------");
        }else {
            System.out.println("------------------------添加失败，人数已满---------------");
        }
    }
    /**
     * @Description 修改客户操作
     */
    private void modifyCustomer(){
        System.out.println("------------------------修改客户------------------------");
        Customer cust;
        int number;
        for(; ;){
            System.out.print("请选择待修改的客户编号（按-1可退出）：");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }
            cust = customerList.getCustomer(number - 1);
            if(cust == null)
            {
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }
        }
        System.out.print("姓名（"+cust.getName()+"）:");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别（"+cust.getGender()+"）:");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄（"+cust.getAge()+"）:");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话（"+cust.getPhone()+"）:");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("邮箱（"+cust.getEmail()+"）:");
        String email = CMUtility.readString(30, cust.getEmail());
        Customer newCust = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number-1, newCust);
        if(isReplaced){
            System.out.println("------------------------修改成功------------------------");
        }else{
            System.out.println("------------------------修改失败------------------------");
        }

    }
    /**
     * @Description 删除客户操作
     */
    private void deleteCustomer(){
        System.out.println("------------------------删除客户------------------------");
        int number;
        for(; ;){
            System.out.print("请选择待删除的客户编号（按-1退出）");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }
            Customer customer = customerList.getCustomer(number - 1);
            if(customer == null){
                System.out.println("无法找到指定客户！");
            }else {
                break;
            }
        }
        // 找到指定的用户，进行删除操作：
        System.out.print("确认是否删除？（Y/N）：");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete == 'Y'){
            customerList.deleteCustomer(number - 1);
            System.out.println("------------------------删除成功------------------------");
        }
    }
    /**
     * @Description 显示客户列表
     */
    private void listAllCustomer(){
        System.out.println("------------------------客户列表------------------------");
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("没有客户记录！");
        }else{
            System.out.println("编号\t姓名\t\t性别\t\t年龄\t\t电话\t\t\t邮箱");
            Customer[] allCustomers = customerList.getAllCustomers();
            for(int i = 0; i<allCustomers.length; i++){
                Customer allCustomer = allCustomers[i];
                System.out.println((i+1)+"\t"+allCustomer.getName()+
                        "\t"+allCustomer.getGender()+"\t\t"+allCustomer.getAge()+"\t\t"+
                        allCustomer.getPhone() +"\t"+allCustomer.getEmail());
            }
        }
        System.out.println("--------------------------------------------------------");
    }
    /**
     * @Description main方法
     */
    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
