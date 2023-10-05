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

#### **Installing IntelliJ IDEA**

https://www.jetbrains.com/help/idea/installation-guide.html

 ### Attention : 

 A video of STEPS below,  you can also see the picture steps below alternatively.

## Step2: Import it in Idea

Download this package to your local repository.

Open eclipse choose **File -> Open-> Folder**.

![image-20231005174410381](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20231005174410381.png)



Edit configuration and run

![image-20231005174539012](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20231005174539012.png)

When you see this, that means the web application is start with no error.

![image-20231005174637935](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20231005174637935.png)

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

