
  const ctx = document.getElementById('myChart');

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['월', '화', '수', '목', '금', '토','일'],
      datasets: [
        {
        label: '소',
        data: [12, 19, 3, 5, 2, 3, 6, 7,9,12,7,9],
        borderWidth: 1,
        Color:'blue'
        },
        {
          label: '돼지',
          data: [12, 19, 3, 5, 2, 3, 6, 7,9,12,7,9],
          borderWidth: 1,
          Color:'green'
        },
        {
          label: '닭',
          data: [12, 19, 3, 5, 2, 3, 6, 7,9,12,7,9],
          borderWidth: 1,
          Color:'red'
        },
        {
          label: '오리',
          data: [12, 19, 3, 5, 2, 3, 6, 7,9,12,7,9],
          borderWidth: 1,
          Color:'yellow'
        }
    ]
    
     
    },
    options: {
     reponsive:true,
    }


  });




