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
        console.log(body);
      });
  }
};

function init() {
  if (document.body.id !== 'question') return;

  // set event handlers
  $('#ask-form').addEventListener('submit', handlers.onClickAskForm);
}
