global.$ = $;
global.$$ = $$;

/**
 * alias
 * @returns {Function} querySelector
 */
function $() {
  return document.querySelector.apply(document, arguments);
}

/**
 * alias
 * @returns {Function} querySelectorAll
 */
function $$() {
  return document.querySelectorAll.apply(document, arguments);
}
