window.addEventListener('DOMContentLoaded', init);

let handlers = {
  onClickAskForm: function(e) {
    e.preventDefault();

    let form = e.target;
    fetch(form.action, {
      method: form.method,
      body: new FormData(form),
      credentials: 'include'}).then(res => {
        return res.text();
      }).then(body => {
        var tmpEl = document.createElement('div');
        tmpEl.innerHTML = `<div class="panel panel-error">body</panel>`;
        form.appendChild(tmpEl.childNodes[0]);
      });
  }
};

function init() {
  if (document.body.id !== 'question') return;

  // set event handlers
  $('#ask-form').addEventListener('submit', handlers.onClickAskForm);
}
