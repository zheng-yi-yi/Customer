package service;
import bean.Customer;
/**
 * @Description 内部用数组来管理一组`Customer`对象，并提供相应的添加、修改、删除以及遍历方法
 * @author zhengyiyi
 * @date 2022年9月5日上午8:30
 */
public class CustomerList {
    private Customer[] customers;   // 用于保存客户对象的数组;
    private int total = 0;          // 记录已保存客户对象的数量

    /**
     * 用于初始化Customer数组的构造器
     * @param totalCustomer：指定数组的长度
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * @Description 将指定的用户添加到数组中
     * @param customer Customer对象
     * @return true：添加成功，  false：添加失败
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }
    /**
     * @Description 修改指定索引处的客户信息；
     * @param index 指定的索引；
     * @param cust Customer对象；
     * @return true：添加成功，  false：添加失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >= total) {
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * @Description 删除指定索引处的对象；
     * @param index 指定的索引；
     * @return true：删除成功，  false：删除失败
     */
    public boolean deleteCustomer (int index){
        if(index < 0 || index >= total){
            return false;
        }
        for (int i = index; i<total-1; i++) {
            customers[i] = customers[i+1];
        }
        // 最后一个数据需要置空
        customers[total - 1] = null;

        total--;
        return true;
    }

    /**
     * @Description 获取所有客户信息；
     * @return Customer数组
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i<total; i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * @Description 获取指定索引上的客户
     * @param index 指定索引
     * @return 如果找到元素则返回，否则返回null
     */
    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * @Description 获取客户的数量
     * @return
     */
    public int getTotal(){
        return total;
    }







}
