$(".answer-write input[type=submit]").click(addAnswer);

function addAnswer(e) {
  console.log('click');
  e.preventDefault();

  let queryString = $(".answer-write").serialize();
  console.log("query: " + queryString);

  let url = $(".answer-write").attr("action");
  console.log("url: " + url);

  $.ajax({
    type: 'post',
    url: url,
    data: queryString,
    dataType: 'json',
    error: onError,
    success: onSuccess
  });
}

function onError() {

}

function onSuccess(data, status) {
  console.log(data);
}