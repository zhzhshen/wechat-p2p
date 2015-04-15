package Util;

import Entity.Menu.BasicButton;
import Entity.Menu.Button;
import Entity.Menu.ComplexButton;
import Entity.Menu.Menu;
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
        btn11.setName("天气预报");
        btn11.setType("click");
        btn11.setKey("11");

        BasicButton btn12 = new BasicButton();
        btn12.setName("公交查询");
        btn12.setType("click");
        btn12.setKey("12");

        BasicButton btn13 = new BasicButton();
        btn13.setName("周边搜索");
        btn13.setType("click");
        btn13.setKey("13");

        BasicButton btn14 = new BasicButton();
        btn14.setName("历史上的今天");
        btn14.setType("click");
        btn14.setKey("14");

        BasicButton btn21 = new BasicButton();
        btn21.setName("歌曲点播");
        btn21.setType("click");
        btn21.setKey("21");

        BasicButton btn22 = new BasicButton();
        btn22.setName("经典游戏");
        btn22.setType("click");
        btn22.setKey("22");

        BasicButton btn23 = new BasicButton();
        btn23.setName("美女电台");
        btn23.setType("click");
        btn23.setKey("23");

        BasicButton btn24 = new BasicButton();
        btn24.setName("人脸识别");
        btn24.setType("click");
        btn24.setKey("24");

        BasicButton btn25 = new BasicButton();
        btn25.setName("聊天唠嗑");
        btn25.setType("click");
        btn25.setKey("25");

        BasicButton btn31 = new BasicButton();
        btn31.setName("Q友圈");
        btn31.setType("click");
        btn31.setKey("31");

        BasicButton btn32 = new BasicButton();
        btn32.setName("电影排行榜");
        btn32.setType("click");
        btn32.setKey("32");

        BasicButton btn33 = new BasicButton();
        btn33.setName("幽默笑话");
        btn33.setType("click");
        btn33.setKey("33");

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("生活助手");
        mainBtn1.setSub_button(new BasicButton[]{btn11, btn12, btn13, btn14});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("休闲驿站");
        mainBtn2.setSub_button(new BasicButton[]{btn21, btn22, btn23, btn24, btn25});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("更多体验");
        mainBtn3.setSub_button(new BasicButton[]{btn31, btn32, btn33});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});

        return menu;
    }
}
