package Util;

import Entity.Menu.*;
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
        ViewButton btn11 = new ViewButton();
        btn11.setName("账户资金");
        btn11.setType("view");
        btn11.setUrl(Global.TRANSACTION_HISTORY_URL);

        ViewButton btn12 = new ViewButton();
        btn12.setName("持有标的");
        btn12.setType("view");
        btn12.setUrl(Global.MY_SUBJECTS_URL);

        ViewButton btn13 = new ViewButton();
        btn13.setName("充值");
        btn13.setType("view");
        btn13.setUrl(Global.TOPUP_URL);

        ViewButton btn14 = new ViewButton();
        btn14.setName("取现");
        btn14.setType("view");
        btn14.setUrl(Global.WITHDRAW_URL);

        ViewButton btn15 = new ViewButton();
        btn15.setName("注册");
        btn15.setType("view");
        btn15.setUrl(Global.REGISTER_URL);

        ViewButton bt16 = new ViewButton();
        bt16.setName("Test");
        bt16.setType("view");
        bt16.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx520c15f417810387&redirect_uri=http%3A%2F%2Fchong.qq.com%2Fphp%2Findex.php%3Fd%3D%26c%3DwxAdapter%26m%3DmobileDeal%26showwxpaytitle%3D1%26vb2ctag%3D4_2030_5_1194_60&response_type=code&scope=snsapi_base&state=123#wechat_redirect");


        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("我的资产");
        mainBtn1.setSub_button(new Button[]{btn11, btn12, btn14, btn15, bt16});


        ViewButton btn2 = new ViewButton();
        btn2.setName("我要投资");
        btn2.setType("view");
        btn2.setUrl(Global.SUBJECTS_URL);

        BasicButton btn3 = new BasicButton();
        btn3.setName("优惠资讯");
        btn3.setType("click");
        btn3.setKey(Global.EVENT_SALES_INFO);

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, btn2, btn3});

        return menu;
    }
}
