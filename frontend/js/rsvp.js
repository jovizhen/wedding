 var family = [];
 var householder;
 var email;

 function updateForm() {
	var isNameValid = document.getElementById("name").checkValidity();
	var isAgeValid = document.getElementById("ageGroup").checkValidity();
	var isMealValid = document.getElementById("mainCourse").checkValidity();
	if(isNameValid && isAgeValid && isMealValid){
		var name = document.mealForm.name.value; 
        var ageGroup = document.mealForm.ageGroup.value;
        var mainCourse = document.mealForm.mainCourse.value;

        var person = {
        	name:name,
        	ageGroup:ageGroup,
        	mainCourse:mainCourse
        }
        family.push(person);
        var table=document.getElementById("results");
        var row=table.insertRow(-1);
        var cell1=row.insertCell(0);
        var cell2=row.insertCell(1);
        var cell3=row.insertCell(2);
        cell1.innerHTML=name;
        cell2.innerHTML=ageGroup;        
        cell3.innerHTML=mainCourse;  

        document.mealForm.name.value ="";
        document.mealForm.ageGroup.value="";
        document.mealForm.mainCourse.value="";
	}			
}  

function resetFamily() {
	family = [];
}

function saveFamily() {

}

function toggleForm() {

var ageGroup = document.mealForm.ageGroup.value;
        var mainCourse = document.mealForm.mainCourse.value;

	var isNameValid = document.getElementById("houseHolderName").checkValidity();
	var isEmailValid = document.getElementById("houseHolderEmail").checkValidity();
	if(isNameValid && isEmailValid){
		householder = document.myform.houseHolderName.value;
        email = document.myform.houseHolderEmail.value;

		var x = document.getElementById("attendBtn");
		var hn = document.getElementById("houseHolderName");
		var he = document.getElementById("houseHolderEmail");
		$('#collapseForm').collapse('show');
	  	x.style.display = "none";
	  	hn.disabled = true;
	  	he.disabled = true;
	}
}

function saveMeals(){

if(householder && email){
	var request = {
		name:householder,
		email:email,
		meals:family
	}	
	householder=null;
	email=null;
	family=[];
	$.ajax({
	      type: "POST",
	      url: "https://9ot0ul0oyc.execute-api.us-east-2.amazonaws.com/stg/meals",
	      data: JSON.stringify(request),
    	  contentType: "application/json",
	      success: function(resultData){
	          window.location.replace("success.html")
	      }
      });
	}
	
}

function onComplete() {
	if(family.length==0){
		$("#warnModal").modal('show');
	}else{
		$("#exampleModal").modal('show');
	}
}