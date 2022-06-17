//팝업 기능

const open_popup = (e) => {
  console.log(e);
  switch (e) {
    case "linkedit":
      console.log("합");
      document
        .querySelector(".group-interview-popup_content")
        .classList.remove("hidden");
      break;
    case "portimg":
      document.querySelector(".imgpopup").classList.remove("hidden");
      break;
    case "portvi":
      document.querySelector(".vipopup").classList.remove("hidden");
      break;
    case "portlink":
      document.querySelector(".linkpopup").classList.remove("hidden");
      break;
  }
};

const close_popup = () => {
  console.log("닫");
  popup = document.querySelectorAll(".popup-content");
  popup.forEach((element) => {
    element.classList.add("hidden");
  });
};

// document.querySelector(".openBtn").addEventListener("click", open);
// document.querySelector(".closeBtn").addEventListener("click", close);
// document.querySelector(".bg").addEventListener("click", close);
