package com.itheima;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//自定义窗口类，创建对象，展示主窗口
public class MainFrame extends JFrame {
    //设置图片常量
    private static final String imagePath = ("stoneMaze/src/image/");
    //准备一个二维数组用于存储数字色块的行列位置: 4 * 4。
    private final int[][] imageData = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //定义一个二维数组记录胜利的状态
    private final int[][] winData = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    private int row;//存储空白色块的行位置
    private int col;//存储空白色块的列位置
    private int count;//步数,默认为0

    public MainFrame(){
        //1、调用一个初始化方法 初始化窗口。
        initFrame();
        //4、打乱色块的顺序，在展示色块。
        initRandomArray();
        //2、初始化界面，展示数字色块。
        initUI();
        //3、初始化系统菜单: 点击弹出菜单信息是系统退出，重启游戏
        initMenu();
        //5、给当前窗口绑定上下左右事件
        initKeyPressEvent();
        //设置窗口可见
        this.setVisible(true);
    }

    private void initKeyPressEvent() {
        //给当前窗口绑定上下左右按键事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获取当前按钮的编号
                int keyCode = e.getKeyCode();
                //判断这个编号是否可以绑定按键的上下左右事件
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        SwitchAndMove(Direction.UP);
                        break;
                        //用户点击了上键
                    case KeyEvent.VK_DOWN:
                        SwitchAndMove(Direction.DOWN);
                        break;
                        //用户点击了下键
                    case KeyEvent.VK_LEFT:
                        SwitchAndMove(Direction.LEFT);
                        break;
                        //用户点击了左键
                    case KeyEvent.VK_RIGHT:
                        SwitchAndMove(Direction.RIGHT);
                        break;
                        //用户点击了右键
                }
            }
        });
    }
    private void SwitchAndMove(Direction r){
                switch (r){
                    case UP:
                        //上交换的条件是length < 3 开始交换。
                        if(row < imageData.length - 1){
                            //交换位置
                            int temp = imageData[row][col];
                            imageData[row][col] = imageData[row + 1][col];
                            imageData[row + 1][col] = temp;
                            //更新空白色块的位置
                            row++;
                            count++;
                        }
                        break;
                    case DOWN:
                        if(row > 0){
                            //交换位置
                            int temp = imageData[row][col];
                            imageData[row][col] = imageData[row - 1][col];
                            imageData[row - 1][col] = temp;
                            //更新空白色块的位置
                            row--;
                            count++;
                        }
                        break;
                    case LEFT:
                        if(col < imageData[row].length - 1){
                            //交换位置
                            int temp = imageData[row][col];
                            imageData[row][col] = imageData[row][col + 1];
                            imageData[row][col + 1] = temp;
                            //更新空白色块的位置
                            col++;
                            count++;
                        }
                        break;
                    case RIGHT:
                        if(col > 0){
                            //交换位置
                            int temp = imageData[row][col];
                            imageData[row][col] = imageData[row][col - 1];
                            imageData[row][col - 1] = temp;
                            //更新空白色块的位置
                            col--;
                            count++;
                        }
                        break;
                }
                initUI();
    }
    private void initRandomArray() {
        //1、打乱二维数组的顺序
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData.length; j++) {
            //随机两个数的行列，打乱顺序
                int i1 = (int)(Math.random() * imageData.length);
                int j1 = (int)(Math.random() * imageData.length);

                int i2 = (int)(Math.random() * imageData.length);
                int j2 = (int)(Math.random() * imageData.length);

                int temp = imageData[i1][j1];
                imageData[i1][j1] = imageData[i2][j2];
                imageData[i2][j2] = temp;
            }
        }
        //定位空白色块位置
        //遍历二维数组，找到0，0的位置就是空白色块的位置
        OUT:
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                if(imageData[i][j] == 0){
                    row = i;
                    col = j;
                    break OUT;//跳出循环
                }
            }
        }
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();//创建菜单条
        JMenu menu = new JMenu("系统");//创建菜单
        JMenuItem exitJi = new JMenuItem("退出");
        menu.add(exitJi);
        menu.addActionListener(e -> {
            dispose();//销毁窗口
        });
        //添加菜单条,重启
        JMenuItem restartJi = new JMenuItem("重启");
        menu.add(restartJi);
        restartJi.addActionListener(e -> {
            dispose();//销毁窗口
            //重启窗口：打乱二维数组
            initRandomArray();
            //刷新窗口
            initUI();
        });
        menuBar.add(menu);//添加菜单
        this.setJMenuBar(menuBar);
    }

    private void initUI() {
        //先清空窗口图层
        this.getContentPane().removeAll();

        //刷新界面时显示移动步数
        //设置一个展示文字的标签
        JLabel countTxt = new JLabel("当前移动" + count +"步");
        countTxt.setBounds(20,20,100,20);
        //把文字显示为红色
        countTxt.setForeground(Color.RED);
        //加粗
        countTxt.setFont(new Font("楷体",Font.BOLD,16));
        this.add(countTxt);
        //判断用户是否赢了
        if(isWin()){
            //显示胜利图片
            JLabel label = new JLabel(new ImageIcon(imagePath + "win.png"));
            label.setBounds(124,230,266,88);
            this.add(label);
        }

        //1、用二维数组展示行列矩阵( 4 * 4)
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                //拿到图片名称
                String imageName = imageData[i][j] + ".png";
                //2、创建一个JLabel对象，设置图片名称
                JLabel label = new JLabel();
                //3、创建一个JLabel对象，设置图片展示
                label.setIcon (new ImageIcon(imagePath + imageName));
                //4、设置数字色块的位置
                label.setBounds( 20 + j * 100, 60 + i * 100, 100, 100);
                //5、把图片展示出来
                this.add(label);

            }
        }
        //设置窗口的背景图片
        JLabel background=new JLabel(new ImageIcon(imagePath + "background.png"));
        background.setBounds(0,0,450,484);
        this.add(background);

        //在刷新窗口
        this.repaint();
    }

    private boolean isWin() {
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                if(imageData[i][j] != winData[i][j]){
                    return false;
                }
            }
        }
        //胜利了
        return true;
    }

    private void initFrame() {
        //设置窗口标题
        this.setTitle("石头迷阵 V 1.0 朱火山" );
        //设置窗口大小
        this.setSize(465,575);
        //设置窗口关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置绝对定位
        this.setLayout(null);
    }

}

