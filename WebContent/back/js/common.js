function reload(){
    window.location.reload();
}
function help(msg){
    alert('欢迎使用'+msg);
}

function to(url){
    window.location.href=url;
}
function back(){
    history.go(-1);
}
function save(url){
    alert('保存成功！');
    to(url);
}
function add(url){
    alert('新建成功！');
    to(url);
}
function del(msg){
    if (window.confirm("确认删除"+msg+"？")){
        reload();
    }
}