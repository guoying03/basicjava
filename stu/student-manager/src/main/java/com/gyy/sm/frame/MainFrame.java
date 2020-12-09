package com.gyy.sm.frame;

import com.gyy.sm.VO.StudentVo;
import com.gyy.sm.component.CustomPanel;
import com.gyy.sm.entity.Clazz;
import com.gyy.sm.entity.Department;
import com.gyy.sm.factory.ServiceFactory;
import com.gyy.sm.utils.AliOSSUtil;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/21
 **/
public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPanel;
    private JPanel leftPanel;
    private JPanel bottomPanel;
    private JPanel addDepPanel;
    private JTextField depNameField;
    private JButton 选择图片Button;
    private JPanel toolBarPanel;
    private JButton 新增院系Button;
    private JButton 切换显示Button;
    private JPanel contentPanel;
    private JPanel rightPanel;
    private JLabel logoLabel;
    private JButton 新增Button;
    private JComboBox <Department> depCombobox;
    private JTextField searchField;
    private JButton 新增班级Button;
    private JPanel treePanel;
    private JPanel classConcentPanel;
    private JPanel tablePanel;
    private JComboBox<Department> departmentJBox;
    private JComboBox<Clazz> clazzJBox;
    private JTextField searchField1;
    private JButton 搜索Button;
    private JButton 新增学生Button;
    private JButton 批量导入Button;

    private final CardLayout c;
    private String uploadFileUrl;
    private File file;
    private int departmentId = 0;
    private List<StudentVo> students;


    public MainFrame() {
        init();
        c = new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1", departmentPanel);
        centerPanel.add("2", classPanel);
        centerPanel.add("3", studentPanel);
        centerPanel.add("4", rewardPanel);

        院系管理Button.addActionListener(e -> {
            c.show(centerPanel, "1");
        });
        班级管理Button.addActionListener(e -> {
            c.show(centerPanel, "2");
            showClazz();
        });
        学生管理Button.addActionListener(e -> {
            c.show(centerPanel, "3");
            showStudents(ServiceFactory.getStudentServiceInstance().selectAll());
        });
        奖惩管理Button.addActionListener(e -> {
            c.show(centerPanel, "4");
        });
        showDepartments();

        新增院系Button.addActionListener(e -> {
            //获取左侧面板的可见性
            boolean visible = addDepPanel.isVisible();
            //不可见
            if (!visible) {
                //向右侧展开、背景色变化、可见
                leftPanel.setPreferredSize(new Dimension(180, this.getHeight() - 100));
                addDepPanel.setVisible(true);
            }else{
                //向左侧展开、背景色变化、可见
                leftPanel.setPreferredSize(new Dimension(60, this.getHeight() - 100));
                addDepPanel.setVisible(false);
            }

            leftPanel.revalidate();
        });

        //院系名称文本框焦点监听
        depNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
            @Override
            public void focusLost(FocusEvent e){

            }
        });

        选择图片Button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("D:/QQ/photo/"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if (result == JFileChooser.APPROVE_OPTION){
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                URL url;
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(150, 150));

                //图片强制缩放成和JLabel一样大小
                icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(),logoLabel.getHeight(),Image.SCALE_DEFAULT));
                logoLabel.setIcon(icon);
            }
        });



        新增Button.addActionListener(e ->{
            //上传文件到OSS并返回url
            uploadFileUrl = AliOSSUtil.ossUpload(file);
            //创建Department对象，并设置相应属性
            Department department = new Department();
            department.setDepartmentName(depNameField.getText().trim());
            department.setLogo(uploadFileUrl);
            //调用service实现新增功能
            int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if (n == 1){
                JOptionPane.showMessageDialog(centerPanel,"新增院系成功");
                //新增成功后，将侧边栏隐藏
                leftPanel.setPreferredSize(new Dimension(60,this.getHeight()-100));
                addDepPanel.setVisible(false);
                //刷新界面数据
                showDepartments();
                //清空文本框
                depNameField.setText("");
                logoLabel.setIcon(null);
            }else{
                JOptionPane.showMessageDialog(centerPanel,"新增院系失败");
            }

        });

        depCombobox.addActionListener(e ->{
           //得到选中的索引
            int index = depCombobox.getSelectedIndex();
            //按照索引取出项，就是一个Department对象，然后取出其id
             departmentId = depCombobox.getItemAt(index).getId();
        });

        //新增班级
        新增班级Button.addActionListener(e -> {
            Clazz clazz = new Clazz();
            clazz.setDepartmentId(departmentId);
            clazz.setClassName(searchField.getText().trim());
            int n = ServiceFactory.getClazzServiceInstance().addClazz(clazz);
            if (n==1){
                JOptionPane.showMessageDialog(centerPanel,"新增班级成功");
                searchField.setText("");
                showClazz();
            }else{
                JOptionPane.showMessageDialog(centerPanel,"新增班级失败");
            }
        });

        学生管理Button.addActionListener(e -> {
            c.show(centerPanel, "3");
            showStudents(ServiceFactory.getStudentServiceInstance().selectAll());

            departmentJBox.addItem(Department.builder().departmentName("请选择院系").build());
            List<Department> departments = ServiceFactory.getDepartmentServiceInstance().selectAll();
            for (Department department : departments) {
                departmentJBox.addItem(department);
            }

            clazzJBox.addItem(Department.builder().departmentName("请选择班级").build());
            List<Clazz> clazzes = ServiceFactory.getClazzServiceInstance().selectAll();
            for (Clazz clazz : clazzes) {
                clazzJBox.addItem(clazz);
            }





            CustomPanel stuInfoPanel = new CustomPanel("D:/QQ/photo/T1.jpg");
            stuInfoPanel.setPreferredSize(new Dimension(300, 600));
            stuInfoPanel.repaint();
            stuInfoPanel.add(stuInfoPanel, BorderLayout.EAST);
            JLabel title = new JLabel("学生信息");
            title.setFont(new Font("楷体", Font.BOLD, 20));
            title.setForeground(new Color(97, 174, 239));
            stuInfoPanel.add(title);

            departmentJBox.addItemListener(e1 -> {
                if (e1.getStateChange() == ItemEvent.SELECTED){
                    int index = departmentJBox.getSelectedIndex();
                    if (index != 0) {
                        Integer depId = departmentJBox.getItemAt(index).getId();
                        students = ServiceFactory.getStudentServiceInstance().selectByDepId(depId);
                        showStudents(students);
                        List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(depId);
                        clazzJBox.removeAllItems();
                        clazzJBox.addItem(Clazz.builder().className("请选择班级").build());
                        for (Clazz clazz : clazzList) {
                            clazzJBox.addItem(clazz);
                        }
                    }else {
                        students = ServiceFactory.getStudentServiceInstance().selectAll();
                        showStudents(students);
                        clazzJBox.removeAllItems();
                        clazzJBox.addItem(Clazz.builder().className("请选择班级").build());
                        List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectAll();
                        for (Clazz clazz : clazzList) {
                            clazzJBox.addItem(clazz);
                        }
                    }
                }
            });

            clazzJBox.addItemListener(e2 -> {
                if (e2.getStateChange() == ItemEvent.SELECTED) {
                    int index = clazzJBox.getSelectedIndex();
                    if (index != 0) {
                        Integer classId = clazzJBox.getItemAt(index).getId();
                        List<StudentVo> studentList = ServiceFactory.getStudentServiceInstance().selectByClassId(classId);
                        showStudents(studentList);
                    }else {
                        clazzJBox.removeAllItems();
                        clazzJBox.addItem(Clazz.builder().className("请选择班级").build());
                       List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectAll();
                        for (Clazz clazz : clazzList) {
                            clazzJBox.addItem(clazz);
                        }
                    }
                }
            });
        });

        搜索Button.addActionListener(e -> {
            students = ServiceFactory.getStudentServiceInstance().selectByKeywords(searchField.getText().trim());
            showStudents(students);
            searchField.setText("");
        });
    }

    /**
     * 显示所有院系
     */
    private void showDepartments(){
        //移除原有数据
        contentPanel.removeAll();
        //从service层获取到多有院系列表
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len = departmentList.size();
        //根据院系总数算出行数（每行放4个）
        int row = len % 4 == 0 ? len / 4 : len / 4 + 1;
        //创建一个网格布局，每行4列，指定水平和垂直间距
        GridLayout gridLayout = new GridLayout(row, 4, 15, 15);
        contentPanel.setLayout(gridLayout);
        for (Department department : departmentList) {
            //给每个院系对象创建一个面板
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(400, 400));
            depPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

            JLabel nameLabel = new JLabel(department.getDepartmentName());
            //设置合适大小
//            depPanel.setPreferredSize(new Dimension(200,200));

            //将院系名称设置给面板标题
            depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            depNameField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    depNameField.setText("");
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });
            //新建一个JLabel标签，用来放置院系Logo，并设置大小
            JLabel logoLabel = new JLabel("<html><img src= '" + department.getLogo() + "'width='200' height='200' /><ml>");
            //占位空白标签
            JLabel blankLabel = new JLabel();
            blankLabel.setPreferredSize(new Dimension(200, 30));
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            //院系面板加入主题内容面板
            contentPanel.add(depPanel);
            //删除按钮
            JButton delBtn = new JButton("删除");
            //删除院系
            delBtn.addActionListener(e -> {
                int n = ServiceFactory.getDepartmentServiceInstance().delDepartment(department, department.getId());
                if ( n == 1){
                    JOptionPane.showMessageDialog(centerPanel, "删除院系成功");
                    showDepartments();
                }else {
                    JOptionPane.showMessageDialog(centerPanel,"删除院系失败");
                }
            });
            //按钮加入院系面板
            depPanel.add(delBtn);
            //刷新主体内容面板
            contentPanel.revalidate();
        }
    }

    private void showClazz(){
        List<Department> departments = ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departments);
        showTree(departments);
        showClazz(departments);
    }

  private void showCombobox(List<Department> departments){
        for (Department department : departments){
            depCombobox.addItem(department);
        }
  }


    private void showTree(List<Department> departments){
        treePanel.removeAll();
        //左侧树组件到根结点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("南京工业职业技术大学");
        for (Department department : departments){
            DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
            root.add(group);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
            for (Clazz clazz : clazzList){
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(clazz.getClassName());
                group.add(node);
            }
        }

        final JTree tree = new JTree(root);
        tree.setRowHeight(30);
        tree.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        treePanel.add(tree, BorderLayout.CENTER);
        treePanel.revalidate();

    }

    private void showClazz(List<Department> departments){
        classConcentPanel.removeAll();
        classConcentPanel.setLayout(new GridLayout(0,5,15,15));
        Font titleFont = new Font("微软雅黑", Font.PLAIN, 16);
        for (Department department : departments){
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(120,150));
            depPanel.setBackground(new Color(63,98,131));
            depPanel.setLayout(new BorderLayout());
            JLabel depNameLabel = new JLabel (department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setForeground(new Color(255,255,255));
            depPanel.add(depNameLabel, BorderLayout.NORTH);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
            DefaultListModel<Clazz> listModel = new DefaultListModel<>();
            for (Clazz clazz : clazzList){
                listModel.addElement(clazz);
            }
            JList<Clazz> jList = new JList<>(listModel);
            jList.setBackground(new Color(101,134,184));
            JScrollPane scrollPane = new JScrollPane(jList);
            depPanel.add(scrollPane, BorderLayout.CENTER);
            classConcentPanel.add(depPanel);

            //对每个JList增加弹出菜单
             JPopupMenu jPopupMenu = new JPopupMenu();
             JMenuItem modifyItem = new JMenuItem("修改");
             JMenuItem deleteItem = new JMenuItem("删除");
             jPopupMenu.add(modifyItem);
             jPopupMenu.add(deleteItem);
             jList.add(jPopupMenu);

             jList.addMouseListener(new MouseAdapter() {
                 @Override
                 public void mouseClicked(MouseEvent e) {
                     int index = jList.getSelectedIndex();
                     if (e.getButton() == 3){
                         jPopupMenu.show(jList, e.getX(), e.getY());
                         Clazz clazz = jList.getModel().getElementAt(index);
                         deleteItem.addActionListener(e1 -> {
                             int choice = JOptionPane.showConfirmDialog(depPanel, "确定删除吗？");
                             if (choice == 0) {
                                 int n = ServiceFactory.getClazzServiceInstance().deleteClazz(clazz.getId());
                                 if (n == 1) {
                                     listModel.remove(index);
                                     showTree(ServiceFactory.getDepartmentServiceInstance().selectAll());
                                 }
                             }
                         });
                     }
                 }
             });

        }
    }

    private void showStudents(List<StudentVo> studentVos){
//        CustomPanel stuInfoPanel = new CustomPanel("D:\\QQ\\photo\\T1.jpg");
//        stuInfoPanel.setPreferredSize(new Dimension(300,600));
//        JLabel title = new JLabel("学生信息");
//        title.setFont(new Font("楷体",Font.BOLD,20));
//        title.setForeground(new Color(97,174,239));
//        stuInfoPanel.add(title);
//        stuInfoPanel.repaint();
//        studentPanel.add(stuInfoPanel,BorderLayout.EAST);
//
//        //获得学生列表数据
//        List<StudentVo> students = ServiceFactory.getStudentServiceInstance().selectAll();
        //先移除表格
        tablePanel.removeAll();
        //创建表格对象
        JTable table = new JTable();
        //创建表格数据模型，并设置给表格
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //设置表头内容
        model.setColumnIdentifiers(new String[]{"学号","院系","班级","姓名","性别","地址","手机号","出生日期","头像"});
        //遍历list,生成Object数组，数组中的每一个元素都是一行记录
        for (StudentVo student : students){
            Object[] object = new Object[]{
                    student.getId(),student.getDepartmentName(),student.getClassName(),
                    student.getStudentName(),student.getGender(),
                    student.getAddress(),student.getPhone(),student.getBirthday(),
                    student.getAvatar()
            };
            //添加数据模型
            model.addRow(object);
        }
        //设置最后一列不显示在表格中(头像)
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMaxWidth(0);
        tc.setMinWidth(0);
        //获得表格的表头
        JTableHeader header = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        header.setDefaultRenderer(hr);
        //设置表头字体
        header.setPreferredSize(new Dimension(header.getWidth(),40));
        header.setFont(new Font("楷体",Font.PLAIN,18));
        //设置表头行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223,241,234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);
        //表格加入滚动面板，并设置水平和垂直方向均可按需滚动
        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        //表格内容监听，根据点击的行得到不同的数据
        table.getSelectionModel().addListSelectionListener(e ->{
            int row = table.getSelectedRow();
            StudentVo studentVo = StudentVo.builder()
                    .className(table.getValueAt(row, 2).toString())
                    .studentName(table.getValueAt(row, 3).toString())
                    .phone(table.getValueAt(row, 6).toString())
                    .address(table.getValueAt(row, 5).toString())
                    .build();
            System.out.println(studentVo);
//            JOptionPane.showMessageDialog(null,table.getValueAt(row,2).toString()+
//                    table.getValueAt(row,3).toString());
        });
    }


    public void init(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }


    public static void main(String[] args){
        new MainFrame();
    }
}
