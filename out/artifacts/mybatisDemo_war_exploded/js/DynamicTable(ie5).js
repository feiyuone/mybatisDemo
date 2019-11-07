function analysisTemplate(tpl) {
    var reg = new RegExp("\n", "g");
    tpl = tpl.replace(reg, "");
    var TDArr = tpl.split("</td>");
    for (var i = 0; i < TDArr.length; i++) {
        if (TDArr[i]) {
            TDArr[i] = TDArr[i].replace("<td>", "");
            TDArr[i] = TDArr[i].replace("</td>", "");
            TDArr[i] = TDArr[i].replace("        ", "");
        }
    }
    TDArr.splice(-1,1);
    return TDArr;
}

function judgeTpl(obj) {
    while (!(obj.tagName !== undefined && obj.getAttribute("name") === "template")) {
        obj = obj.nextSibling;
    }
    return obj;
}

function AddRow(obj) {
    var DymTab;
    if (obj != null || obj !== undefined) {
        DymTab = obj;
    } else {
        DymTab = document.getElementById("example");
    }
    var tbody = DymTab.getElementsByTagName("tbody")[0];
    var rowNum = DymTab.rows.length;

    var tpl = judgeTpl(DymTab.nextSibling);
    var tplHtml = tpl.innerHTML;
    var objTR = DymTab.insertRow(rowNum);
    var cellsArr = analysisTemplate(tplHtml);
    //objTR.innerHTML = tplHtml;
    for (var j = 0; j < cellsArr.length; j++) {
        var TDcell = objTR.insertCell(j);
        TDcell.innerHTML = cellsArr[j];
        objTR.appendChild(TDcell);
    }
    tbody.appendChild(objTR);
    objTR.cells[1].innerText = rowNum;
}

function DelRow(obj) {
    var DymTab;
    if (obj != null || obj !== undefined) {
        DymTab = obj;
    } else {
        DymTab = document.getElementById("example");
    }
    var inputArr = DymTab.getElementsByTagName("input");
    var checkboxArr = [];
    for (var j = 0; j < inputArr.length; j++) {
        if (inputArr[j].type === "checkbox") {
            checkboxArr.push(inputArr[j]);
        }
    }
    //var selectBox = document.getElementsByName("selectBox");
    for (var i = checkboxArr.length - 1; i >= 0; i--) {
        if (checkboxArr[i].checked) {
            DymTab.deleteRow(i + 1);
        }
    }
    updateOder(DymTab);
}

function updateOder(DymTab) {
    var rows = DymTab.rows;
    var rowNum = rows.length;
    for (var i = 0; i < rowNum; i++) {
        var row = rows[i + 1];
        if (row !== undefined) {
            var xhTD = row.cells[1];
            xhTD.innerText = i + 1;
        }
    }
}

function chgOpration(obj) {
    var rowIndex = obj.parentNode.parentNode.rowIndex;
    var table = obj.parentNode.parentNode.parentNode;
    if (table.tagName.toLowerCase() === "tbody") {
        table = table.parentNode;
        AddRow(table);
    }
    obj.innerHTML = "删除";
    obj.innerText = "删除";
    obj.onclick = function () {
        table.deleteRow(rowIndex);
        updateOder(table);
    };
}

function checkNeedFill() {
    //var spanArr = tab.querySelectorAll(".needFill");
    var spanArr = $(".needFill");
    var input;
    var flag = true;
    for (var i = 0; i < spanArr.length; i++) {
        input = spanArr[i].nextSibling;
        if (input.value === "") {
            input.title = "此项必填";
            input.className = "inputNeedFill";
            input.onchange = function () {
                if (this.value !== "") {
                    this.title = "";
                    this.className = "input";
                }
            }

        } else {
            if (input.className === "inputNeedFill") {
                input.title = "";
                input.className = "input";
            }
        }
    }
    // if (tab.querySelectorAll(".inputNeedFill").length>0){
    if ($(".inputNeedFill").length > 0) {
        flag = false;
    }
    return flag;
}

/**
 * @return {boolean}
 */
function SaveDataTable() {
    var DymTabs = document.getElementsByName("example");
    var DymTab;
    var data = "{ \"data0\":";
    for (var m = 0; m < DymTabs.length; m++) {
        //DymTab = document.getElementById("example");
        DymTab = DymTabs[m];
        if (!checkNeedFill(DymTab)) {
            alert("标红框的部分为必填内容，请填写");
            return false;
        }
        var rowArr = DymTab.rows;
        var rowNum = rowArr.length;
        var row = "";
        var cell = "";
        var tabData = "[";
        var rowData = "";
        if (m > 0) {
            data = data + ",\"data" + m + "\":";
        }
        for (var i = 1; i < rowNum; i++) {
            if (i > 1) {
                tabData = tabData + ","
            }
            rowData = "{";
            row = rowArr[i];
            var inputFields = row.getElementsByTagName("input");
            for (var j = 0; j < inputFields.length; j++) {
                if (inputFields[j].getAttribute("type") === "text") {
                    if (rowData.length > 1) {
                        rowData = rowData + ",";
                    }
                    rowData = rowData + "\"" + inputFields[j].name + "\":\"" + inputFields[j].value + "\"";
                }

            }
            rowData = rowData + "}";
            tabData = tabData + rowData;
        }
        tabData = tabData + "]";
        data = data + tabData;
    }
    data = data + "}";
    document.getElementById("dataStore").innerText = data;
    return true;
}

function loadDymTabData() {
    //var DymTab = document.getElementById("example");
    var DymTabs = document.getElementsByName("example");
    var DymTab;
    var DymTabData = document.getElementById("dataStore").innerText;
    //var jsonData = eval("(" + DymTabData + ")"); //IE6及以下使用
    var jsonData = JSON.parse(DymTabData);
    var dataLength = 0;
    for (var data in jsonData) {
        dataLength += 1;
    }
    var tpl = document.getElementsByName("template");
    //var dataLength = jsonData.length;
    for (var m = 0; m < DymTabs.length; m++) {
        DymTab = DymTabs[m];
        var tbody = DymTab.getElementsByTagName("tbody")[0];
        var rowArr = DymTab.rows;
        var rowNum = rowArr.length;
        var tplHtml = tpl[m].innerHTML;
        var cellsArr = analysisTemplate(tplHtml);
        var key = "";
        var objTR = "";
        var inputFields = "";
        var subobj = "data" + m.toString();
        var tabRowData;
        if (dataLength !== 0) {
            tabRowData = jsonData[subobj];
        }
        if (rowNum > 1) {
            for (var n = 1; n < rowNum; n++) {
                objTR = rowArr[n];
                inputFields = objTR.getElementsByTagName("input");
                for (var j = 0; j < inputFields.length; j++) {
                    key = inputFields[j].name;
                    if (tabRowData !== undefined) {
                        inputFields[j].value = eval("tabRowData[n-1]." + key);
                        inputFields[j].readOnly = true;
                    } else {

                    }

                }
                objTR.cells[1].innerText = n;
            }

        } else {
            if (tabRowData !== undefined) {
                for (var i = 0; i < tabRowData.length; i++) {
                    objTR = DymTab.insertRow(rowNum + i);
                    for (var j = 0; j < cellsArr.length; j++) {
                        var TDcell = objTR.insertCell(j);
                        TDcell.innerHTML = cellsArr[j];
                        objTR.appendChild(TDcell);
                    }
                    //objTR.innerHTML = tplHtml;
                    tbody.appendChild(objTR);
                    inputFields = objTR.getElementsByTagName("input");
                    for (var j = 0; j < inputFields.length; j++) {
                        if (undefined !== tabRowData) {
                            key = inputFields[j].name;
                            inputFields[j].value = eval("tabRowData[i]." + key);
                            inputFields[j].readOnly = true;
                        }

                    }
                    objTR.cells[1].innerText = i + 1;
                }
            }
        }
    }
}
