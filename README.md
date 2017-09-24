# TruckCodeChallenge
An Android Project for Asana Rebel Code Challenge

<img src="/assets/sample.gif" width="49%">

This project aims to solve the Truck Code Challenge. It is written in Kotlin. 

Code Design and Architectural Solution

	The framework made for this challenge was initially made with the MVP pattern in mind. 
  	It also abides in CLEAN Architecture with SOLID principles.
  
Libraries Used

	• Kotlin
	• Retrofit
	• RxJava
	• Gson
	
Requirements Fullfilled:
	
	● Minimum API 16. 
	-- Minimum Apk set to 16 
	● Third-party libraries is allowed.
	-- Only Used Essentials as entried above
	● As the web services can return a really long list of manufacturers and models, we would
	like to see some pagination in the list. Page size: 15 elements.
	-- Added Search than Pagination
	● We want to show the previously selected values when showing a new screen.
	-- Main Screen has the previously selected values before going into the dialog screen
	● Ideally, transition between lists should be animated.
	-- Loading screen
	● We expect to see different layout for odd and even rows.
	-- Yellow layous for odd rows, White in even rows
	● App is expected to work in portrait and landscape mode flawlessly.
	-- Yup
	
Added Features:
	
	• As described above, used MVP + Clean Architecture for separations of classes
	• Used SearchView instead of pagination
	• Added JUnit Test Values for MainPresenter and DialogPresenter 
	• Error Checking on the frontend as well
	• Animated gif for showing features
	
