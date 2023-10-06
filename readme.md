# Application function

**Func 1:** Post  Receipt info in json format

![4](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/4.png)

![12](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/12.png)

**Func 2:** Get points of the Receipt by id

![14](https://github.com/LIANGYIXUAN3335/receiptProcess/blob/main/readme%20hyperlink/14.png)

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

Choose **"POST"** in Method and type "http://localhost:8080/receipts/process" **in** **"SCHEME"** 

Then add a json file Receipt in Body and Choose **"Send"**

Then we can find the Response below with generated ID of  the Receipt we've posted.

If the ID is wrong, we will get 400 bad request.

Copy the Id and paste it in the position below then click **Send**, then we get  **{"points ": "xx" }** below in the response body. 

## API Documentation

### 1. Retrieve Receipt Points

- **Endpoint**: `/receipts/{id}/points`

- **HTTP Method**: `GET`

- **Description**: Retrieve the points associated with a given receipt.

- Path Parameters

  - `id` (UUID): The unique identifier of the receipt.

- Response

  - 200 OK

    If the receipt exists.

    - Body

      ```json
      {
        "points": <int>
      }
      ```

  - 400 Bad Request

    If the receipt doesn't exist or invalid UUID is provided.

    - Body

      ```json
      {
        "error": "Receipt with id:<id> not found."
      }
      ```

### 2. Save a Receipt

- **Endpoint**: `/receipts/`

- **HTTP Method**: `POST`

- **Description**: Save a new receipt to the database.

- Request Body

  ```json
  {
    "retailer": "M&M Corner Market",
    "purchaseDate": "2022-03-20",
    "purchaseTime": "14:33",
    "items": [
      {
        "shortDescription": "Gatorade",
        "price": "2.25"
      },{
        "shortDescription": "Gatorade",
        "price": "2.25"
      },{
        "shortDescription": "Gatorade",
        "price": "2.25"
      },{
        "shortDescription": "Gatorade",
        "price": "2.25"
      }
    ],
    "total": "9.00"
  }
  ```

- Response

  - **200**

    ```json
    {
    "id": "35818cf8-35e9-4664-b6ca-802b88da46e8"
    }
    ```

  - **400 Bad Request**: If the request body is invalid.

------

## Suggested Order of Improvements

1. **Integration with Kafka**:
   - Before diving into Kubernetes, I'd recommend integrating Kafka first. It will make your application capable of handling real-time data efficiently. The move to an event-driven architecture will ensure that your system is more resilient to spikes in traffic and can scale more smoothly.
2. **Kubernetes (k8s) Deployment**:
   - Once you have an event-driven setup with Kafka, deploying on Kubernetes would be the next logical step. Kubernetes will further amplify the benefits you get from Kafka by ensuring that your application is always available, scales automatically, and can be updated or rolled back without downtime.
3. **Further API Extensions & Documentation**:
   - As your application grows, you might want to add more functionalities. With every new feature, ensure that your API documentation is kept up-to-date. Clear and concise documentation can greatly accelerate development and debugging efforts, especially when working in a team.
4. **Monitoring & Logging**:
   - With your infrastructure set up, you should invest in good monitoring and logging tools. This will help you keep an eye on your system's health and debug any issues that arise.
