const supabaseUrl = 'https://xkrmziwitmrwyhjbksyr.supabase.co';
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inhrcm16aXdpdG1yd3loamJrc3lyIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDkxMzEwNTUsImV4cCI6MjA2NDcwNzA1NX0.eoobBVYOTaQIR38OrKmpWUtja3L02h-DRDAFZbf6sRk';
const supabaseClient = supabase.createClient(supabaseUrl, supabaseKey);

const form = document.getElementById('loginForm');
const message = document.getElementById('message');
const buttonContainer = document.getElementById('buttonContainer');
const toggle = document.getElementById('versionToggle');
const rememberContainer = document.getElementById('rememberContainer');

async function loadVersion() {
  const { data, error } = await supabaseClient
    .from('W1')
    .select('version')
    .eq('id', 1)
    .single();

  if (error) {
    console.error('Error fetching version:', error);
    return;
  }

  const version = data.version;
  applyVersion(version);
  toggle.checked = version === 'updated';
}

toggle.addEventListener('change', async () => {
  const newVersion = toggle.checked ? 'updated' : 'normal';
  const { error } = await supabaseClient
    .from('W1')
    .update({ version: newVersion })
    .eq('id', 1);

  if (error) {
    console.error('Error updating version:', error);
    return;
  }
  applyVersion(newVersion);
});

function applyVersion(mode) {
  const button = document.getElementById('loginButton') || document.getElementById('submitBtnUpdated');
  if (!button) return;

  if (mode === 'updated') {
    button.id = 'submitBtnUpdated';
    button.textContent = 'Sign In';
    rememberContainer.classList.remove('d-none');
  } else {
    button.id = 'loginButton';
    button.textContent = 'Login';
    rememberContainer.classList.add('d-none');
  }

  form.setAttribute('data-version', mode);
}

form.addEventListener('submit', function (e) {
  e.preventDefault();

  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const remember = document.getElementById('remember').checked;
  const version = form.getAttribute('data-version');

  const rememberRequired = version === 'updated';

  if (username === 'admin' && password === '12345' && (!rememberRequired || remember)) {
    message.textContent = 'Login successful!';
    message.style.color = '#2e7d32';
  } else {
    message.textContent = 'Login failed.';
    message.style.color = 'red';
  }
});

loadVersion();