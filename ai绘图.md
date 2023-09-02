## 教程1

西瓜姬

https://www.bilibili.com/video/BV1Qe4y1c7Eb/?spm_id_from=333.999.0.0&vd_source=a5116378ed55a7a52afc94f577036c38

![image-20230325004909182](ai绘图.assets/image-20230325004909182.png)

```
正面  
<lora:koreanDollLikeness_v10:0.4>, (RAW photo, best quality, masterpiece:1.2), ultra-detailed, ultra high res, (aegyo sal:1), 1 girl, Kpop idol, busty, (short hair:1.2), posing, (nose blush), (smile:1.1), (closed mouth), huge breasts, beautiful detailed eyes, floating hair, professional lighting, photo mapping, radiosity, physically-based rendering, slender waist, Muscle line, white tights, looking at viewer, Ultra-short tight short sleeves, (mini skirt:1.5), standing, plump legs, office, fantasy light

负面 
child,EasyNegative, nipples, cleavage, paintings, sketches, (worst quality:2), (low quality:2), (normal quality:2), lowres, normal quality, ((monochrome)), ((grayscale)), skin spots, acnes, skin blemishes, age spot, glans,extra fingers,fewer fingers,((watermark:2)),((white letters:1))
```

我的

```
模型
<lora:koreanDollLikeness_v10:0.4>, 
画质
(RAW photo, best quality, masterpiece:1.2), ultra-detailed, ultra high res, professional lighting, photo mapping, radiosity, physically-based rendering,
环境
fantasy light, office, 
人物形象
1 girl, Kpop idol, (aegyo sal:1),
五官
(long hair:1.2),floating hair, (nose blush), beautiful detailed eyes, 
身材
slender waist, Muscle line, plump legs, 
动作
looking at viewer, posing, (laughing:1.1), (open mouth),  standing, 
```

## 教程2

https://www.bilibili.com/video/BV1Z84y1H7vL/?spm_id_from=333.999.0.0&vd_source=a5116378ed55a7a52afc94f577036c38

![image-20230325004236320](ai绘图.assets/image-20230325004236320.png)



# lora 训练

整体流程

1. 准备要训练的照片
2. 通过训练包中的 tagger 自动分析照片并打tag
3. 构造 `./train/<模型名>/<训练次数>_<概念>` 目录, 将 打 tag 后的照片和tag.txt 放进去
4. 设置底模路径, 指定一个大模型
5. 设置训练集路径, 即步骤3中的目录

## controlnet

需要 预处理+对应模型 共同协作才能生成图片

## 需要的插件

controlnet, 预处理器+模型

network, lora 对比预览

脚本-xyz 图表



![image-20230722152929427](ai绘图.assets/image-20230722152929427.png)

















