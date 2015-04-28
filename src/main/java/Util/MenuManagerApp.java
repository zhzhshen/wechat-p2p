package Util;

import Entity.Menu.BasicButton;
import Entity.Menu.Button;
import Entity.Menu.ComplexButton;
import Entity.Menu.Menu;
import Resource.Global;
import api.MenuSupport;

/**
 * Created by twer on 4/15/15.
 *
 * Create customized menu from calling api
 */
public class MenuManagerApp {
    public static void main(String[] args) {

        int result = MenuSupport.createMenu(getMenu());

        // 判断菜单创建结果
        if (0 == result)
            System.out.println("菜单创建成功！");
        else
            System.out.println("菜单创建失败，错误码：" + result);

    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        BasicButton btn11 = new BasicButton();
        btn11.setName("账户资金");
        btn11.setType("click");
        btn11.setKey(Global.EVENT_ACCOUNT_PROFILE);

        BasicButton btn12 = new BasicButton();
        btn12.setName("持有标的");
        btn12.setType("click");
        btn12.setKey(Global.EVENT_SUBJECTS);

        BasicButton btn13 = new BasicButton();
        btn13.setName("充值");
        btn13.setType("click");
        btn13.setKey(Global.EVENT_TOPUP);

        BasicButton btn14 = new BasicButton();
        btn14.setName("取现");
        btn14.setType("click");
        btn14.setKey(Global.EVENT_WITHDRAW);


        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("我的资产");
        mainBtn1.setSub_button(new BasicButton[]{btn11, btn12, btn13, btn14});


        BasicButton btn2 = new BasicButton();
        btn2.setName("我要投资");
        btn2.setType("click");
        btn2.setKey(Global.EVENT_INVESTMENT);

        BasicButton btn3 = new BasicButton();
        btn3.setName("优惠资讯");
        btn3.setType("click");
        btn3.setKey(Global.EVENT_SALES_INFO);

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, btn2, btn3});

        return menu;
    }
}
