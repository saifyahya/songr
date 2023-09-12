function toggleForm(songId) {
  var formId = 'form-' + songId;
  var form = document.getElementById(formId);

  if (form.style.display === 'none') {
    form.style.display = 'block';
  } else {
    form.style.display = 'none';
  }
}