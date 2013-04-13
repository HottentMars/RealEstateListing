function start() {
myform.V1.disabled = true;

myform.V2.disabled = true;
myform.V3.disabled = true;
myform.V4.disabled = true;
myform.V5.disabled = true;
}

onload = start;

function chgtx1() {
myform.V1.disabled  = !myform.cb1.checked;
}

function chgtx2() {
myform.V2.disabled = !myform.cb2.checked;
}

function chgtx3() {
myform.V3.disabled = !myform.cb3.checked;}

function chgtx4() {
myform.V4.disabled = !myform.cb4.checked;
} 

function chgtx5() {
myform.V5.disabled = !myform.cb5.checked;
} 

function enableText()
{
	myform.V1.disabled = false; 
	myform.V2.disabled = false;
	myform.V3.disabled = false;
	myform.V4.disabled = false;
	myform.V5.disabled = false;
}
