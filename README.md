# ReviewerApp
## Steps for app

1. Import the logo file into: app/src/main/res/drawable and name it ic_logo_vector.xml\
*If you don't have an XML image file you import the logo into src/main/res/drawable-v24/ and name it logo.png. Next step is changing every ImageView where app:srcCompat="@drawable/ic_logo.vector" to "@drawable/logo"* <br />
<br />

2. Get the place id: https://developers.google.com/maps/documentation/javascript/examples/places-placeid-finder 
![Places Finder](https://i.imgur.com/FEEVmvq.png)
<br />

3. Make a QR-Code (https://www.the-qrcode-generator.com/) with the following link as destination: https://search.google.com/local/writereview?placeid=  (Here you paste the place-id from step2)
<br />

4. Import the QR-code file into: src/main/res/drawable-v24/ and name it qrcode.png
<br />

5. Change colorPrimary in src/main/AndroidManifest.xml to the brand color.
<br />

6. Make a Gmail account for the company and name it: (company)reviewer@gmail.com
<br />

7. Change the Gmail accounts access for less secure app to "ON" at https://myaccount.google.com/security
<br />

8. In the file app/src/main/java/com/servi/reviewerafium/Global.java you change every variable to desired strings.
<br />

## Steps for tablet

1. Settings -> Lock screen and security -> Other security settings -> Pin windows -> On
2. Settings -> Navigation -> Select the first option & turn navigation bar off.
3. Open app -> Pin app -> hide nav bar
