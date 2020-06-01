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
        goods1.setName("�ʼǱ�����");
        goods2.setName("ƻ���ֻ�");
        goods3.setName("��Ϊ�ֻ�");
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
            System.out.println("*****��ӭ��������̳�*****");
            System.out.println("      1.ע��");
            System.out.println("      2.��¼");
            System.out.println("      3.�鿴�̳�");
            System.out.println("      4.�鿴�ҹ������Ʒ");
            System.out.println("      5.����Ա��¼");
            System.out.println("      6.�˳�ϵͳ");
            System.out.println("***********************");
            System.out.println("��ѡ��˵�:");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("��ѡ��Ĳ˵��ǣ�ע��");
                    register();
                    break;
                case 2:
                    System.out.println("��ѡ��Ĳ˵��ǣ���¼");
                    login();
                    break;
                case 3:
                    System.out.println("��ѡ��Ĳ˵��ǣ��鿴�̳�");
                    lookGoods();
                    break;
                case 4:
                    System.out.println("��ѡ��Ĳ˵��ǣ��鿴�ҹ������Ʒ");
                    lookMyGoods();
                    break;
                case 5:
                    System.out.println("��ѡ��Ĳ˵��ǣ�����Ա��¼");
                    adminLogin();
                    break;
                case 6:
                	System.out.println("*****�˳�ϵͳ��******");
                    System.exit(0);
                default:
                    System.out.println("��������ȷ�Ĳ˵���(1-6)!");
            }
        }
    }
    private static void register(){
        Scanner scanner=new Scanner(System.in);
        Map<String,String> user = new HashMap<>();
        System.out.println("�������û��˺�:");
        String username=scanner.next();
        System.out.println("�������û�����:");
        String password=scanner.next();
        System.out.println("���ٴ�ȷ����������:");
        String resetPassword=scanner.next();
        if (password.equals(resetPassword)){
            user.put(username,password);//username�����ظ����ظ�ֻ��¼���һ���û��˺�
            userInfoList.add(user);
            System.out.println("����У����ȷ��");
            System.out.println("ע��ɹ���");
        }else {
            System.out.println("����У�����");
        }return;
    }
    private static void login(){
        Scanner scanner=new Scanner(System.in);
        Map<String,String> user = new HashMap<>();
        System.out.println("�������û��˺�:");
        String username=scanner.next();
        System.out.println("�������û�����:");
        String password=scanner.next();
        String passwordCheck=null;
        for(int i=0;i<userInfoList.size();i++){
            passwordCheck = (String)userInfoList.get(i).get(username);//��ȡ����Ӧ��key=usernameʱ��valueֵ��������ö�Ӧ��password
            if (password.equals(passwordCheck)){
                System.out.println("��½�ɹ�");
                return;
            }
        }
        System.out.println("�û������벻��ȷ����½ʧ�ܣ�");
        return;
    }
    private static void lookGoods() {
        System.out.println("��Ʒ�б����£�");
        for (Goods goods:goodsList) {
            System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",num="+goods.getNumber()+"]");
        }
        System.out.println("��ѡ����Ҫ�������Ʒ��ţ�");
        Scanner scanner=new Scanner(System.in);
        int selectGoodsNum=scanner.nextInt();
        System.out.println("��ѡ����Ҫ�������Ʒ������");
        int goodsNumber=scanner.nextInt();
        System.out.println("�����Ƿ��������Y/N");
        String select=scanner.next();
        if("N".equals(select)){
            System.out.println("�ѷ�������");
            return;
        }else if("Y".equals(select)){
            for (Goods goods:goodsList) {
              if(selectGoodsNum == (goods.getId())){
                    goods.setNumber(goodsNumber);
                    myGoodsList.add(goods);
                    System.out.println("��Ʒ����ɹ���");
                    System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",�������Ʒ������="+goods.getNumber()+"]");
                    System.out.println("�ܼ۸�"+goods.getCount());
                    return;
                }
            }           
        }
        System.out.println("���ʧ��");
    }
    private static void lookMyGoods() {
        System.out.println("��Ҫ�������Ʒ��");
        int zongcount=0;
        for ( Goods goods: myGoodsList ) {
        	System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",�������Ʒ������="+goods.getNumber()+"]");
            System.out.println("�ܼۣ�"+goods.getCount());
            int a=goods.getCount();
            zongcount+=a;
        }
        System.out.println("�����������Ʒ�ܼ�Ϊ�� ");
        System.out.println(zongcount);
    }
    private static void adminLogin() {
        Scanner scanner=new Scanner(System.in);
        Map<String,String> user = new HashMap<>();
        System.out.println("���������Ա�˺�:");
        String username=scanner.next();
        System.out.println("���������Ա����:");
        String password=scanner.next();
        if ("admin".equals(username) && "123".equals(password)){
            System.out.println("��½�ɹ�");
            adminMenu();
        }else {
            System.out.println("��½ʧ��");
            return;
        }
    }
    private static void adminMenu() {
    	Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("*****����Ա�˵�*****");
            System.out.println("      1.�����Ʒ");
            System.out.println("      2.�޸���Ʒ");
            System.out.println("      3.ɾ����Ʒ");
            System.out.println("      4.�鿴��Ʒ�б�");
            System.out.println("      5.�˳�");
            System.out.println("***********************");
            System.out.println("��ѡ��˵�:");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("��ѡ��Ĳ˵��ǣ�1.�����Ʒ");
                    add();
                    break;
                case 2:
                    System.out.println("��ѡ��Ĳ˵��ǣ�2.�޸���Ʒ");
                    update();
                    break;
                case 3:
                    System.out.println("��ѡ��Ĳ˵��ǣ�3.ɾ����Ʒ");
                    delete();
                    break;
                case 4:
                    System.out.println("��ѡ��Ĳ˵��ǣ�4.�鿴��Ʒ�б�");
                    looklist();
                    break;
                case 5:
                	System.out.println("*****�˳�******");
                	Menu();;
                default:
                    System.out.println("��������ȷ�Ĳ˵���(1-5)!");
            }
        }  
    }
    private static void add(){
    	System.out.println("******��ʼ�����Ʒ******");
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("��������Ʒ��ţ�");
    	int id=scanner.nextInt();
    	System.out.println("��������Ʒ���ƣ�");
    	String name=scanner.next();
    	System.out.println("��������Ʒ�۸�");
    	int price=scanner.nextInt();
    	System.out.println("��������Ʒ������");
    	int number=scanner.nextInt();
    	Goods goods4 = new Goods();
    	goods4.setId(id);
    	goods4.setName(name);
    	goods4.setPrice(price);
    	goods4.setNumber(number);
    	goodsList.add(goods4);
    	System.out.println("******��Ʒ��ӳɹ���******");
    }
    private static void update(){
    	System.out.println("******��ʼ�޸���Ʒ******");
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("��������Ҫ�޸ĵ���Ʒ��ţ�");
    	int id=scanner.nextInt();
    	System.out.println("����Ʒ��Ϣ���£�");
    	for (int i = 0; i < goodsList.size(); i++) {
			if(id==goodsList.get(i).getId()){
				System.out.println("Goods:[id="+goodsList.get(i).getId()+",name="+goodsList.get(i).getName()+",price="+goodsList.get(i).getPrice()+",num="+goodsList.get(i).getNumber()+"]");
				System.out.println("��������Ʒ���ƣ�");
		    	String updatename=scanner.next();
		    	System.out.println("��������Ʒ�۸�");
		    	int updateprice=scanner.nextInt();
		    	System.out.println("��������Ʒ������");
		    	int updatenumber=scanner.nextInt();
		    	Goods goods = new Goods();
                goods.setId(goodsList.get(i).getId());
                goodsList.remove(i);
                goods.setName(updatename);
                goods.setPrice(updateprice);
                goods.setNumber(updatenumber);
                goodsList.add(goods);
                System.out.println("�޸ĳɹ���");
			}
		}	
    }
    private static void delete(){
    	System.out.println("******��ʼɾ����Ʒ******");
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("��������Ʒ��ţ�");
    	int id=scanner.nextInt();
    	System.out.println("******��ɾ������Ʒ�б�����******");
    	for (int i = 0; i < goodsList.size(); i++) {
			if(id==goodsList.get(i).getId()){
				System.out.println("Goods:[id="+goodsList.get(i).getId()+",name="+goodsList.get(i).getName()+",price="+goodsList.get(i).getPrice()+",num="+goodsList.get(i).getNumber()+"]");
				System.out.println("�Ƿ�ȷ��ɾ����Y/N");
		    	String select=scanner.next();
		    	if("Y".equals(select)){
		    		goodsList.remove(goodsList.get(i));
		    		System.out.println("******��Ʒɾ���ɹ�******");
		        }else if ("N".equals(select)){
		        	return;
		        }
			}
    	}
    }
    private static void looklist(){
    	System.out.println("******��Ʒ�б�******");
    	for (Goods goods : goodsList) {
    		System.out.println("Goods:[id="+goods.getId()+",name="+goods.getName()+",price="+goods.getPrice()+",num="+goods.getNumber()+"]");
    	}
    }
}