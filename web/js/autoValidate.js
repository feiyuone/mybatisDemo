// css类字典：记录input编辑框的className，用于在非空之后，还原输入框的class
function classNameDict() {
    this.data = [];
    this.add = add;
    this.find = find;
}

//查找
function find(key) {
    return this.data[key];
}

//添加
function add(key, value) {
    this.data[key] = value;
}

function checkNeedFill() {
    var spanArr = dojo.query(".needfill");
    var input;
    var flag = true;
    var span = "";
    var classNames = new classNameDict();
    console.info(classNames);
    for (var i = 0; i < spanArr.length; i++) {
        input = spanArr[i].parentNode.nextSibling.childNodes[0];
        span = addSpan(input.parentNode);
        span.innerHTML = "<font color=red>&nbsp;&nbsp;&nbsp;此项是必填项</font>";
        if (input.type === "text" && input.value == "") {
            classNames.add(input.name, input.className);
            input.parentNode.appendChild(span);
            input.title = "此项必填";
            input.className = "inputneedfill " + classNames.find(input.name);
            input.style.border = "1px solid orangered";
            input.onchange = function () {
                if (this.value !== "") {
                    this.title = "";
                    this.className = classNames.find(this.name);
                    this.style.border = "1px solid #E1E1E1";
                    var node = addSpan(this.parentNode);
                    this.parentNode.removeChild(node);
                }
            }
            console.warn(input);

        } else {
            if (input.className == "inputneedfill") {
                input.title = "";
                input.className = "";
            }
        }
    }
    if (dojo.query(".inputneedfill").length > 0) {
        flag = false;
    }
    return flag;
}

function addSpan(obj) {
    var empspan = document.createElement("span");
    var span = "";
    var flag = false; //必填提醒标识
    for (var j = 0; j < obj.childNodes.length; j++) {
        var content = obj.childNodes[j].innerText;
        if (content != null && content !== "") {
            content = content.replace(/\s+/g, "");

            if (obj.childNodes[j].tagName.toLowerCase() === "span" && content === "此项是必填项") {
                flag = true; //已经有了必填提醒
                span = obj.childNodes[j];
                break;
            }
        }
    }
    if (flag) {
        return span;
    } else
        return empspan;
}