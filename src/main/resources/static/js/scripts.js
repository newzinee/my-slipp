String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function (match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
}

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
  let answerTemplate = $("#answerTemplate").html();
  let template = answerTemplate.format(data.writer.userId, data.formattedCreateDate, data.contents, data.id, data.id);
  $(".qna-comment-slipp-articles").prepend(template);

  $(".answer-write textarea").val('');
}