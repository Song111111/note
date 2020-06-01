package com;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
public class Test {
    static List<Map<String,String>> userInfoList = new ArrayList<>();
    static List<Goods> goodsList = new ArrayList<>();
    static List<Goods> myGoodsList = new ArrayList<>();
    public static void main(String[] args) {
        Goods goods1 = new Goods();
        Goods goods2 = new Goods();
        Goods goods3 = new Goods();
        goods1.setId(1);
        goods2.setId(2);
        goods3.setId(3);
        goods1.setName("笔记本电脑");
        goods2.setName("苹果手机");
        goods3.setName("华为手机");
        goods1.setPrice(9999);
        goods2.setPrice(7999);
        goods3.setPrice(6999);
        goods1.setNumber(100);
        goods2.setNumber(100);
        goods3.setNumber(100);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        Menu();
    }
        private static void Menu(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("*****欢迎进入电子商城*****");
            System.out.println("      1.注册");
            System.out.println("      2.登录");
            System.out.println("      3.查看商城");
            System.out.println("      4.查看我购买的商品");
            System.out.println("      5.管理员登录");
            System.out.println("      6.退出系统");
            System.out.println("***********************");
            System.out.println("请选择菜单:");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("您选择的菜单是：注册");
                    register();
                    break;
                case 2:
                    System.out.println("您选择的菜单是：登录");
                    login();
                    break;
                case 3:
                    System.out.println("您选择的菜单是：查看商城");
                    lookGoods();
                    break;
                case 4:
                    System.out.println("您选择的菜单是：查看我购买的商品");
                    lookMyGoods();
                    break;
                case 5:
                    System.out.println("您选择的菜单是：管理员登录");
                    adminLogin();
                    break;
                case 6:
                	System.out.println("*****退出系统！******");
                    System.exit(0);
                default:
                    System.out.println("请输入正确的菜单项(1-6)!");
            }
        }
    }
    private static void register(){
        Scanner scanner=new Scanner(System.in);
        Map<String,String> user = new HashMap<>();
        System.out.println("请输入用户账号:");
        String username=scanner.next();
        System.out.println("请输入用户密码:");
        String password=scanner.next();
        System.out.println("请再次确认输入密码:");
        String resetPassword=scanner.next();
        if (password.equals(resetPassword)){
            user.put(username,password);//username不能重复，重复只记录最后一个用户账号
            userInfoList.add(user);
            System.out.println("密码校验正确！");
            System.out.println("注册成功！");
        }else {
            System.out.println("密码校验错误");
        }return;
    }
    private static void login(){
        Scanner scanner=new Scanner(System.in);
        Map<String,String> user = new HashMap<>();
        System.out.println("请输入用户账号:");
        String username=scanner.next();
        System.out.println("请输入用户密码:");
        String password=scanner.next();
        String passwordCheck=null;
        for(int i=0;i<userInfoList.size();i++){
            passwordCheck = (String)userInfoList.get(i).get(username);//获取到对应的key=username时的value值，即：获得对应的password
            if (password.equals(passwordCheck)){
                System.out.println("登陆成功");
                return;
            }
        }
        System.out.println("用户名密码不正确，登陆失败！");
        return;
    }
    private static void lookGoods() {
        System.out.println("商品列表如下：");
        for (Goods goods:goodsList) {
            System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",num="+goods.getNumber()+"]");
        }
        System.out.println("请选择你要购买的商品编号：");
        Scanner scanner=new Scanner(System.in);
        int selectGoodsNum=scanner.nextInt();
        System.out.println("请选择你要购买的商品数量：");
        int goodsNumber=scanner.nextInt();
        System.out.println("请问是否继续购买？Y/N");
        String select=scanner.next();
        if("N".equals(select)){
            System.out.println("已放弃购买");
            return;
        }else if("Y".equals(select)){
            for (Goods goods:goodsList) {
              if(selectGoodsNum == (goods.getId())){
                    goods.setNumber(goodsNumber);
                    myGoodsList.add(goods);
                    System.out.println("商品购买成功！");
                    System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",购买该商品的数量="+goods.getNumber()+"]");
                    System.out.println("总价格："+goods.getCount());
                    return;
                }
            }           
        }
        System.out.println("添加失败");
    }
    private static void lookMyGoods() {
        System.out.println("你要购买的商品：");
        int zongcount=0;
        for ( Goods goods: myGoodsList ) {
        	System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",购买该商品的数量="+goods.getNumber()+"]");
            System.out.println("总价："+goods.getCount());
            int a=goods.getCount();
            zongcount+=a;
        }
        System.out.println("您所购买的商品总价为： ");
        System.out.println(zongcount);
    }
    private static void adminLogin() {
        Scanner scanner=new Scanner(System.in);
        Map<String,String> user = new HashMap<>();
        System.out.println("请输入管理员账号:");
        String username=scanner.next();
        System.out.println("请输入管理员密码:");
        String password=scanner.next();
        if ("admin".equals(username) && "123".equals(password)){
            System.out.println("登陆成功");
            adminMenu();
        }else {
            System.out.println("登陆失败");
            return;
        }
    }
    private static void adminMenu() {
    	Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("*****管理员菜单*****");
            System.out.println("      1.添加商品");
            System.out.println("      2.修改商品");
            System.out.println("      3.删除商品");
            System.out.println("      4.查看商品列表");
            System.out.println("      5.退出");
            System.out.println("***********************");
            System.out.println("请选择菜单:");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("您选择的菜单是：1.添加商品");
                    add();
                    break;
                case 2:
                    System.out.println("您选择的菜单是：2.修改商品");
                    update();
                    break;
                case 3:
                    System.out.println("您选择的菜单是：3.删除商品");
                    delete();
                    break;
                case 4:
                    System.out.println("您选择的菜单是：4.查看商品列表");
                    looklist();
                    break;
                case 5:
                	System.out.println("*****退出******");
                	Menu();;
                default:
                    System.out.println("请输入正确的菜单项(1-5)!");
            }
        }  
    }
    private static void add(){
    	System.out.println("******开始添加商品******");
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("请输入商品编号：");
    	int id=scanner.nextInt();
    	System.out.println("请输入商品名称：");
    	String name=scanner.next();
    	System.out.println("请输入商品价格：");
    	int price=scanner.nextInt();
    	System.out.println("请输入商品数量：");
    	int number=scanner.nextInt();
    	Goods goods4 = new Goods();
    	goods4.setId(id);
    	goods4.setName(name);
    	goods4.setPrice(price);
    	goods4.setNumber(number);
    	goodsList.add(goods4);
    	System.out.println("******商品添加成功！******");
    }
    private static void update(){
    	System.out.println("******开始修改商品******");
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("请输入需要修改的商品编号：");
    	int id=scanner.nextInt();
    	System.out.println("该商品信息如下：");
    	for (int i = 0; i < goodsList.size(); i++) {
			if(id==goodsList.get(i).getId()){
				System.out.println("Goods:[id="+goodsList.get(i).getId()+",name="+goodsList.get(i).getName()+",price="+goodsList.get(i).getPrice()+",num="+goodsList.get(i).getNumber()+"]");
				System.out.println("请输入商品名称：");
		    	String updatename=scanner.next();
		    	System.out.println("请输入商品价格：");
		    	int updateprice=scanner.nextInt();
		    	System.out.println("请输入商品数量：");
		    	int updatenumber=scanner.nextInt();
		    	Goods goods = new Goods();
                goods.setId(goodsList.get(i).getId());
                goodsList.remove(i);
                goods.setName(updatename);
                goods.setPrice(updateprice);
                goods.setNumber(updatenumber);
                goodsList.add(goods);
                System.out.println("修改成功！");
			}
		}	
    }
    private static void delete(){
    	System.out.println("******开始删除商品******");
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("请输入商品编号：");
    	int id=scanner.nextInt();
    	System.out.println("******您删除的商品列表如下******");
    	for (int i = 0; i < goodsList.size(); i++) {
			if(id==goodsList.get(i).getId()){
				System.out.println("Goods:[id="+goodsList.get(i).getId()+",name="+goodsList.get(i).getName()+",price="+goodsList.get(i).getPrice()+",num="+goodsList.get(i).getNumber()+"]");
				System.out.println("是否确定删除？Y/N");
		    	String select=scanner.next();
		    	if("Y".equals(select)){
		    		goodsList.remove(goodsList.get(i));
		    		System.out.println("******商品删除成功******");
		        }else if ("N".equals(select)){
		        	return;
		        }
			}
    	}
    }
    private static void looklist(){
    	System.out.println("******商品列表******");
    	for (Goods goods : goodsList) {
    		System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",num="+goods.getNumber()+"]");
    	}
    }
}