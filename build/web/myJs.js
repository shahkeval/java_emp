/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function frmValidate(frm)
{
    if(frm.txtEroll.value.trim()=="")
    {
        alert("Enter Enrollment number:");
        frm.txtEroll.focus();
        return false;
    }
        if(frm.txtName.value.trim()=="")
    {
        alert("Enter Name:");
        frm.txtName.focus();
        return false;
    }
    if(frm.txtDepart.value.trim()=="")
    {
        alert("Enter Department :");
        frm.txtDepart.focus();
        return false;
    }
    if(frm.txtjava.value.trim()=="")
    {
        alert("Enter java marks:");
        frm.txtjava.focus();
        return false;
    }
     if(isNaN(frm.txtjava.value))
    {
        alert("Enter Numeric Value");
        frm.txtjava.focus();
        return false;
    }
     if(frm.txtmern.value.trim()=="")
    {
        alert("Enter mern marks:");
        frm.txtmern.focus();
        return false;
    }
     if(isNaN(frm.txtmern.value))
    {
        alert("Enter Numeric Value");
        frm.txtmern.focus();
        return false;
    }
    if(frm.txtcuber.value.trim()=="")
    {
        alert("Enter cyber marks:");
        frm.txtcuber.focus();
        return false;
    }
     if(isNaN(frm.txtcuber.value))
    {
        alert("Enter Numeric Value");
        frm.txtcuber.focus();
        return false;
    }
    return true;
}
function isNum(evt)
{
    var charCode = (evt.which) ? evt.which:event.keyCode
    if(charCode==46)
    {
        return true;
    }
    else if(!(charCode>=48 && charCode<=57))
    {
        return false;
    }
    return true;
}
function doDisplay()
{
     document.forms[0].action="CRUD.bsr?action=display";
     document.forms[0].submit();
}
function doSearch()
{
    document.forms[0].action="dispRec.jsp";
    document.forms[0].submit();
}
function doHome()
{
    document.forms[0].action="index.jsp";
    document.forms[0].submit();
}
function doConfirmDel()
{
    if(confirm("Are you sure you want to Delete!!!"))
    {
        return true;
    }
    else
    {
        return false;
    }
}





