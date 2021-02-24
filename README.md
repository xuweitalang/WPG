# WPG
组件化开发框架
组件化开发框架可以将各个子模块独立出来单独运行，方便团队开发，且能够减少打包时间，提高开发效率。
组件化开发框架分为：主模块、子模块、公共模块
主模块相当于项目的外壳，子模块对应项目的各个模块，公共模块是各个模块的基础，主模块和子模块都需要依赖公共模块。
所有公共的功能需放在公共模块中。主模块依赖子模块。子模块之间的跳转通过ARouter来实现。

###组件化模式：子模块可单独运行
将config.gradle文件中的isRelease改为false

###集成化模式：子模块不能单独运行
将config.gradle文件中的isRelease改为true

###子module创建注意事项
module名称以module_开头，这里以module_demo为例：
java名以demo开头，如：DemoMainActivity
资源名称以demo开头：如：demo_activity_main

###其他注意事项：
项目中使用了android推荐的view的初始化框架ViewBinding,编写好layout布局后，通过make project就可以生成Binding结尾的类。
比如MainActivity中的layout布局是activity_main,make project后会生成ActivityMainBinding类，然后可以直接通过该类调用布局中的view。

