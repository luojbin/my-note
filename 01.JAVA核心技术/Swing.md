# █ Swing 图形程序设计

# 一. 图形组件

## 1. 框架 Frame

在往 frame 中添加组件时, 要注意添加次序的问题, 以及尺寸



## panel.setPreferredSize + frame.pack

Frame.pack() 方法根据**最后一个添加**组件的 preferredSize 自动调节



## frame.setSize+ panel.setSize

当为 Frame s设置了 Size 时, 往 Frame 添加的最后一个 panel 会自动被拉伸填满整个 Frame

其余的 panel 则会按照其自身设置的 size 和 location 进行放置, 不会考虑其 preferredSize 

添加的多个 panel, 按照添加测序由上到下排列, 即最先添加的在顶层, 后添加的在下层, 最后添加的则是填充整个  frame







## 2. 面板 Panel

## 3. 组件 Component

# 二. 事件处理

# 三. 多线程

