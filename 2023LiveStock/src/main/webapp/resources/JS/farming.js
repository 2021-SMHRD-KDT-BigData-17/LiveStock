function addColumn() {
    const table = document.getElementById('intro');
    
    for(let i = 0; i < table.column.length; i++)  {
      const newCell =table.column[i].insertCell(-1);
      newCell.innerText = 'New';
    }
  }

<a onClick="window.location.reload()" style="cursor: pointer;">[새로고침]</a>