# indoorpin_sdk_android

*see indoorpin.com for more information*

IndoorpinSDK is used for the mobile integration of Indoorpin CMS. It is strongly recommended to start with quick start part described in CMS (cms.indoorpin.com) Quick Start provides a demo app in the app store so you do not need to deal with SDK at first. 

**After quick start you can start using SDK.**

**STEP 1:**
```
sign up to CMS from cms.indoorpin.com 
Create an application in CMS in application page with "com.infonomi.sampleapp" bundle id and copy the api key.
```
**STEP 2:**
```
Create a branch in CMS (cms.indoorpin.com) in branches page
```
**STEP 3:**
```
Add a floor plan to the added branch in step 2 in CMS in branches page. You have to provide a floor plan image in this step. A sample floor plan image can be found here: https://goo.gl/Tky5ot 
```

**STEP 4:**
```
Add your iBeacon device in Beacon page in CMS. Locate the beacon device on the floor plan you created in step 3.
```

**STEP 5:**
```
Add a campaign in Campaign page in CMS. Select the beacon device you created in step 4. 
``` 

**STEP 6:**
```
Open SampleApp
```

**STEP 7:**
```
In src/com/infonomi/sampleapp/MainActivity.java file replace PUT_YOUR_API_KEY_HERE with the API key that you've copied in step 1.
```

**STEP 8:**
```
Build and run SampleApp on the device.
```

**STEP 9:**
```
Open CMS live map page and see whether you can see Taylor Swift on the floor plan for the application Sample App.
While the sample app is running you will receive push notifications and popups according to your campaign setup
In CMS analytics page, you will be able to see heatmap and analytics data in different formats on the floor plan.
```
----------------------------------------------------------------------------------------------------------------------


**Integrating IndoorpinSdk To Your Own Mobile App:**

**STEP 1:**
```
Add the jar files in your project folder libs
```
**STEP 2:**

Create an indoorpin user class as following:
```
indoorPinUser = new IndoorPinUser(
				null, //Fill this if you want to track the customer with your own database customer id. If this is the case, you should set userDB tof your application to YES in CMS
				"Taylor", 
				"Swift", 
				"http://topnews.in/light/files/taylor-swift_6.jpg?1424841363", 
				"taylorswift@gmail.com", 
				IndoorPinUser.IPGENDER_FEMALE, 
				"1980-01-30" // "yyyy-mm-dd"
		); 
```

