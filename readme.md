# Application function

**Func 1:** Post  Receipt info in json format

![4](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/4.png)

![12](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/12.png)

**Func 2:** Get points of the Receipt by id

![14](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/14.png)

# Guide of start this spring boot application



## Step1: install latest version java and eclipse

#### **Installing Java**

Windows - https://www.youtube.com/watch?v=I0SBRWVS0ok

Linux - https://www.youtube.com/watch?v=mHvFpyHK97A

Mac - https://www.youtube.com/watch?v=U3kTdMPlgsY

#### Troubleshooting

Troubleshooting Java Installation - https://www.youtube.com/watch?v=UI_PabQ1YB0

#### **Installing Eclipse**

Windows - https://www.youtube.com/watch?v=toY06tsME-M

Others - https://www.youtube.com/watch?v=XveQ9Gq41UM

 ### Attention : 

 A video of STEPS below,  you can also see the picture steps below alternatively.

https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/quick%20guide%20of%20running%20this%20application.mp4

## Step2: Import it in eclipse

Download this package to your local repository.

Open eclipse choose **File -> Import -> Maven -> Existing maven projects**.

![2](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/2.png)

When you see the **pom file** as below , click **finish**.

![3](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/3.png)

Right click **project name -> Properties-> Java build path-> double click [jre system library]** 

![5](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/5.png)

Choose **Execution environment -> JavaSE -17**   then apply 

![6](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/6.png)

then choose **Java Compiler** and save settings as below.

![7](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/7.png)

Open the main class **ReceiptProcessApplication.java** and **right click and select" run as" -> 1 java application"**

![8](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/8.png)

Choose **window -> show view -> console**

![9](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/9.png)

When you see this, that means the web application is start with no error.

![10](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/10.png)

## Step3:

Add **Talend API tester** in chrome extension

![11](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/11.png)

Choose **"POST"** in Method and type "http://localhost:8080/receipts/process" **in** **"SCHEME"** 

Then add a json file Receipt in Body and Choose **"Send"**

![4](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/4.png)

Then we can find the Response below with generated ID of  the Receipt we've posted.

![12](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/12.png)

If the ID is wrong, we will get 400 bad request.

![image-20231005173935864](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20231005173935864.png)

Copy the Id and paste it in the position below then click **Send**, then we get  **{"points ": "xx" }** below in the response body. 

![14](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/14.png)

