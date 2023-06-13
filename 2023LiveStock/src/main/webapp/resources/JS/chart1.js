
  const ctx = document.getElementById('myChart');

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['봄', '여름', '가을', '겨울'],
      datasets: [
        {
        label: '소(결핵병)',
        data: [442,414,372,521],
        borderWidth: 1,
        Color:'blue'
        },
        {
          label: '돼지(아프리카돼지열병)',
          data: [0, 0, 12, 6],
          borderWidth: 1,
          Color:'green'
        },
        {
          label: '닭(조류인플루엔자)',
          data: [19045, 1988, 0, 26862],
          borderWidth: 1,
          Color:'red'
        },
        {
          label: '오리(조류인플루엔자)',
          data: [6447, 0, 0, 15103],
          borderWidth: 1,
          Color:'yellow'
        }
    ]
    
     
    },
    options: {
     reponsive:true,
    }


  });




