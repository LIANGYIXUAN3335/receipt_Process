# Application function

**Func 1:** Post  Receipt info in json format

**Func 2:** Get points of the Receipt by id

# Guide of start this spring boot application



## Step1: install java and Idea

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

Open idea choose **File -> Open-> Folder**.

![image-20231005174410381](https://github.com/LIANGYIXUAN3335/receipt_Process/blob/main/readme%20hyperlink/image-20231005174410381.png)

Edit configuration and run

![image-20231005174539012](https://github.com/LIANGYIXUAN3335/receipt_Process/blob/main/readme%20hyperlink/image-20231005174539012.png)

When you see this, that means the web application is start with no error.

![image-20231005174637935](https://github.com/LIANGYIXUAN3335/receipt_Process/blob/main/readme%20hyperlink/image-20231005174637935.png)

## Step3:

Add **Talend API tester** in chrome extension

Choose **"POST"** in Method and type "http://localhost:8080/receipts/process" **in** Talend

Then add a json file Receipt in Body and Choose **"Send"**

Then we can find the Response below with generated ID of  the Receipt we've posted.

If the ID is wrong, we will get 400 bad request.

Copy the Id and paste it in the position below then click **Send**, then we get  **{"points ": "xx" }** below in the response body. 

## API Documentation

------

### 1. Retrieve Receipt Points

#### Response

- **200 OK**: Receipt's points retrieved successfully.

  - Body:

    ```json
    {
      "points": xxx
    }
    ```

- **400 Bad Request**: If an invalid UUID is provided or the specified receipt does not exist.

  - Body:

    ```json
    {
      "error": "Receipt with id:<id> not found."
    }
    ```

### 2. Save a Receipt

#### Response

- **200 OK**: Receipt saved successfully with a unique identifier returned.

  - Body:

    ```json
    {
      "id": "<UUID>"
    }
    ```

- **400 Bad Request**: If the request body is invalid. This could be due to several reasons:

  - Body (one or more might apply):

    ```json
    {
      "error": "Retailer cannot be null or empty."
    }
    ```

    ```json
    {
      "error": "Purchase date cannot be null or in the future."
    }
    ```

    ```json
    {
      "error": "Purchase time cannot be null."
    }
    ```

    ```json
    {
      "error": "Items list cannot be null."
    }
    ```

    ```json
    {
      "error": "Total cannot be null, negative, or zero."
    }
    ```

    ```json
    {
      "error": "Item shortDescription/price is invalid."
    }
    ```

------

## Suggested Order of Improvements

1. Integration with Kafka
   - Before I explore Kubernetes, I'll prioritize integrating with Kafka. By doing so, my application will be adept at handling real-time data. Adopting an event-driven architecture will ensure that our system is robust against traffic spikes and scales easily.
2. Kubernetes (k8s) Deployment
   - After setting up an event-driven environment with Kafka, my next step will be deploying on Kubernetes. This will bolster the advantages derived from Kafka, guaranteeing that our application remains accessible, scales autonomously, and undergoes updates or rollbacks without any downtime.
3. Further API Extensions & Documentation
   - I plan to expand our functionalities as the application evolves. With every new addition, I'll make sure our API documentation is current. Clear documentation will undoubtedly expedite our development and debugging processes, especially in a team environment.
4. Monitoring & Logging
   - I understand the importance of insights, so next time I will add some logs. This will aid in keeping tabs on our system's health and resolving any emerging issues.
