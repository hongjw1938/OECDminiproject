/**
 * 
 */
$(document).ready(function(){
	
	$('#all_set').on('change', function(){
		let x = document.getElementById("all_set").selectedIndex;
		let y = document.getElementById("all_set").options;
		if(y[x].index != 0){
			let id = $('#all_set').val();
			let content = y[x].textContent;
			alert(content + ' 데이터 셋을 가져옵니다..');

			
			$.getJSON('./specific/'+id, function(data){
				let ids = data['id'];
				let descriptions = data['description'];
				
				var items = '<option>원하는 상세분류를 선택해 주십시오.</option>';	
				//$.each(data, function(key, val){
					for(let i=0; i < ids.length; i++){
						items += '<option value=' + ids[i] +'>' + descriptions[i] + '</option>';
					} 
				//})
				
				$('#specific_set').html(items);
			})
			
			
		}
	})
	
	$('#specific_set').on('change', function(){
		let x = document.getElementById("specific_set").selectedIndex;
		let y = document.getElementById("specific_set").options;
		if(y[x].index != 0){
			let id = $('#specific_set').val();
			let content = y[x].textContent;
			alert(content + '목록을 가져옵니다.');
			
			
			
			$.getJSON('./detail/'+id, function(data){
				
				let ids = data['id'];
				let labels = data['label'];
								
				if(ids === undefined){
					var lists = "<option>선택 가능한 content가 없습니다.</option>";
				}
				
				else {
				var lists = '<option>검색할 ' + content + '를 선택해 주십시오.</option>';
					//$.each(data, function(key, val){
						for(let i=0; i < ids.length; i++){
							lists += '<option value=' + ids[i] +'>' + labels[i] + '</option>';
							
						}
					//})
				}
				$('#detail_list').html(lists);		
			})
		}
	})	
})

//가져온 데이터를 Map화
function newMap() {
  var map = {};
  map.value = {};
  map.getKey = function(id) {
    return id;
  };
  map.put = function(id, value) {
    var key = map.getKey(id);
    if(map.contains(key)){
    	map.value[key].push(value);
    } else {
    	map.value[key] = [value];
    }
    
  };
  map.contains = function(id) {
    var key = map.getKey(id);
    if(map.value[key]) {
      return true;
    } else {
      return false;
    }
  };
  map.get = function(id) {
    var key = map.getKey(id);
    if(map.value[key]) {
      return map.value[key];
    }
    return null;
  };
  map.remove = function(id) {
    var key = map.getKey(id);
    if(map.contains(id)){
      map.value[key] = undefined;
    }
  };
 
  return map;
}

//Global variable 생성
//맵을 만든다.
if(typeof map == "undefined"){
	var map = newMap();
}



var query = null;
var startTime = null;
var endTime = null;
var duration = null;

//맵에 값들을 저장하는 함수
function save_values(){
	
	let subject_id = document.getElementById("specific_set").value;	//LOCATION과 같은 id 저장됨
	let detail_id = $("#detail_list option:selected").val();		//AUS와 같은 데이터
	let selected_text = $("#detail_list option:selected").text();			//Austrailia와 같은 데이터 저장
	
	
	
	//맵에 subject_id와 detail_id의 value를 넣는다. 계속 추가함.
	map.put(subject_id, detail_id);
	
	//multiple select에 값들을 추가한다.
	//alert(map.get("LOCATION"));
	//alert(map.get(subject_id));
	
	let option = document.createElement("option");
	option.text = selected_text;
	document.getElementById("sel2").add(option);
}

//쿼리를 만드는 함수
function makeQuery(){
	
	//all_set의 ID
	let all_set_id = document.getElementById("all_set").value;
	
	//subject_id가 있는 select의 options의 개수
	let specifics = document.getElementById("specific_set");
	let length = specifics.options.length;
	
	//multi select box의 모든 값을 지운다.
	let multi_length = document.getElementById("sel2").options.length;
	while(multi_length > 0){
		document.getElementById("sel2").remove(multi_length-1);
		multi_length = document.getElementById("sel2").options.length;
	}
	
	
	let queryTest;
	//subject_id가 저장되어 있는 모든 value값을 가져온다.
	let count = 0;
	
	
	//각각의 subject_id에 따른 map에 저장된 값을 불러와 화면에 뿌리고
	//map을 지운다.
	for(let i=1; i < length; i++){
		let subject_id = specifics.options[i].value;
		if(map.get(subject_id) == null){
			continue;
		}
		
		let map_Vals = map.get(subject_id);
		for(let j=0; j < map_Vals.length; j++){
			if( all_set_id == "DUR_D"){
				if(subject_id == "DURATION"){
					duration = map_Vals[j];
				}
			}
			if( subject_id == "TIME" || subject_id =="YEA"){
				if(document.getElementById("startTime").value == ""){
					document.getElementById("startTime").innerHTML = map_Vals[j];
					startTime = map_Vals[j];
				} else {
					document.getElementById("endTime").innerHTML = map_Vals[j];
					endTime = map_Vals[j];
				}
			} else {
				if( count ==0 ){
					queryTest = map_Vals[j];
					query = map_Vals[j];
				} else if( count != 0 && j == 0) {
					queryTest += "." + map_Vals[j];
					query += "." + map_Vals[j];
				} else {
					queryTest += "+" + map_Vals[j];
					query += "+" + map_Vals[j];
				}
				count++;
			}	
		}
		
	
		
		//map을 클리어 시킨다.
		map.remove(subject_id);
	}
		//확인용 alert
		//alert(query);
		//alert(startTime);
		//alert(endTime);

	document.getElementById("queryTest").innerHTML = queryTest;
	
}

function getData(){
	//location.href ="./index.jsp?query=" + query  + "&start_time=" + startTime;
	location.href="./toExcel?query=" + "\'" +  query + "\'" + "&start_time=" + startTime
		+ "&end_time="+endTime;
		
	if(document.getElementById("all_set").value == "DUR_D"){
		document.getElementById("img").style.visibility="visible";
	} else {
		document.getElementById("img").style.visibility="hidden";
	}
}

function getImg(){

	location.href="./getImg?duration=" + "\'" + duration + "\'";
	//document.getElementById("plot").
}