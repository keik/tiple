import bows from 'bows'

var d = bows('tiple:modeless')
d('loaded')

module.exports = Modeless

function Modeless(html) {
  d('#Modeless', html)

  if (!this instanceof Modeless)
    return new Modeless(html)

  this.el = document.createElement('div')
  this.el.className = 'modeless'
  this.el.innerHTML = html

  if (!this.el.querySelector('.modeless-close'))
    throw new Error('Templates for Modeless must have `.modeless-close` element to close myself')

  this.el.addEventListener('click', onClickModelessClose.bind(this))
  this.el.style.top = (window.scrollY + 150) + 'px'
  this.el.style.left = ((window.innerWidth - 400) / 2) + 'px'
  document.body.appendChild(this.el)

  return this
}

Modeless.prototype.destroy = function() {
  this.el.parentNode.removeChild(this.el)
}

function onClickModelessClose(e) {
  if (!/\bmodeless-close\b/.test(e.target.className))
    return

  this.destroy()
}
