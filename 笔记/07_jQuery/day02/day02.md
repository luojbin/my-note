# 一.jQuery对象和DOM对象
## 1.通过$所获得的对象是jQuery对象
- $("p")
- $(img)
- $("<li></li>")

## 2.调用修改方法返回的是jQuery对象
- obj.width(218)
- obj.html("abc")

## 3.调用读取方法
### 1)若方法返回元素,则是jQuery对象
- obj.parent()
- obj.next()

### 2)若方法返回文本,则是DOM对象
- obj.html()
- obj.attr("src")

# 二.jQuery事件
## 1.事件概述
### 1)什么是事件
- 和js一样

### 2)事件的分类
- 和js一样

## 2.事件定义
### 1)直接定义
- 和js一样

### 2)动态绑定(*)
- 页面加载: $(function(){})
- $("").click(function(){})

### 3)取消事件
- return false
> js和jQuery中都采用这样的方式取消事件

## 3.事件对象
### 1)什么是事件对象
- 和js一样

### 2)如何获取事件对象
#### 直接定义事件时
- 和js一样

#### 动态绑定事件时
- 和js一样
> 获得的event是被jQuery封装后的event

## 4.事件机制
### 1)冒泡机制
- 和js一样

### 2)如何取消冒泡(*)
- e.stopPropagation()

### 3)作用
- 和js一样

### 4)如何获取事件源(*)
- e.target

## 5.合成事件
- 看PPT

## 6.模拟操作(*)
- 看PPT