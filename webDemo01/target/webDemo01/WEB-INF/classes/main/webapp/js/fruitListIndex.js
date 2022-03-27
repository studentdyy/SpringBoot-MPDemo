window.onload=function (){
    var btn = document.getElementsByClassName("btn");
}


function deleteFruit(uid){
    if(confirm('是否确认删除')){
        window.location.href="fruit.do?uid=" + uid+"&operate=delete";
    }

}

function pageContext(pageNum){
    window.location.href="fruit.do?pageNum="+pageNum;
}