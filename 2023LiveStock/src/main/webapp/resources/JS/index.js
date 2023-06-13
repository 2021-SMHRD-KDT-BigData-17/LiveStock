const toggleBtn = document.querySelector('.navbar_toggleBtn');
const menu = document.querySelector('.navbar_menu');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});


        var mapLayer = new ol.layer.Tile({
            source: new ol.source.OSM()
        });

        var map = new ol.Map({
            target: 'map',
            layers: [mapLayer],
            view: new ol.View({
                center: ol.proj.fromLonLat([127.000, 35.717]), // 전라남도 및 전라북도 중심 좌표 설정
                zoom: 7.5
            })
        });

        // 소: 블루 돼지 : 레드 닭: 오렌지 오리: 옐로우
        var markerData = [
            { coordinate: [126.949048, 35.981848], color: 'blue', opacity:0.6 },
            { coordinate: [126.651406, 35.551741], color: 'blue' }, 
            { coordinate: [126.820769, 35.697466], color: 'blue' },
            { coordinate: [126.681002, 35.851666], color: 'blue' },
            { coordinate: [126.810384, 35.663542], color: 'blue' },
            { coordinate: [126.810384, 35.663542], color: 'blue' },
            { coordinate: [126.916637, 35.634337], color: 'blue' },
            { coordinate: [126.996648, 35.841433], color: 'blue' },
            { coordinate: [127.344920, 35.824435], color: 'blue' },
            { coordinate: [127.725559, 35.693498], color: 'blue' },
            { coordinate: [127.827594, 35.697027], color: 'blue' },
            { coordinate: [127.327588, 35.347155], color: 'blue' },
            { coordinate: [127.344888, 35.823979], color: 'blue' },
            { coordinate: [127.129880, 35.459781], color: 'blue' },
            { coordinate: [127.300557, 35.659852], color: 'blue' },
            { coordinate: [126.919789, 35.638060], color: 'blue' },
            { coordinate: [126.919789, 35.638060], color: 'blue' },
            { coordinate: [126.892086, 35.634609], color: 'blue' },
            { coordinate: [127.173705, 36.072164], color: 'blue' },
            { coordinate: [127.929956, 35.603725], color: 'blue' },
            { coordinate: [126.870531, 35.698145], color: 'blue' },
            { coordinate: [127.270875, 35.660289], color: 'blue' },
            { coordinate: [126.781642, 35.813100], color: 'blue' },
            { coordinate: [126.781642, 35.813100], color: 'blue' },
            { coordinate: [126.862341, 35.706471], color: 'blue' },
            { coordinate: [126.977925, 36.013830], color: 'blue' },
            { coordinate: [127.125798, 34.748146], color: 'blue' },
            { coordinate: [127.021758, 34.697007], color: 'blue' },
            { coordinate: [127.088442, 34.785443], color: 'blue' },
            { coordinate: [127.088442, 34.785443], color: 'blue' },
            { coordinate: [126.933589, 34.726891], color: 'blue' },
            { coordinate: [126.907139, 34.696403], color: 'blue' },
            { coordinate: [127.145128, 34.762145], color: 'blue' },
            { coordinate: [126.400289, 35.197047], color: 'blue' },
            { coordinate: [127.199194, 34.775392], color: 'blue' },
            { coordinate: [127.199194, 34.775392], color: 'blue' },
            { coordinate: [126.461616, 34.990354], color: 'blue' },
            { coordinate: [126.745921, 34.993764], color: 'blue' },
            { coordinate: [127.024410, 34.699769], color: 'blue' },
            { coordinate: [127.574501, 34.791949], color: 'blue' },
            { coordinate: [127.068918, 34.744085], color: 'blue' },
            { coordinate: [127.627798, 34.722348], color: 'blue' },
            { coordinate: [126.488149, 35.120746], color: 'blue' },
            { coordinate: [126.472574, 35.034419], color: 'blue' },
            { coordinate: [126.591162, 35.202286], color: 'blue' },
            { coordinate: [127.103719, 35.273945], color: 'blue' },
            

            // 돼지
            { coordinate: [127.706981, 37.980841], color: 'red' },
            { coordinate: [127.210658, 37.980841], color: 'red' },
            { coordinate: [127.224911, 38.016508], color: 'red' },
            { coordinate: [127.177076, 38.006515], color: 'red' },
            { coordinate: [128.634529, 38.027234], color: 'red' },
            { coordinate: [126.592612, 37.715865], color: 'red' },
            { coordinate: [127.279341, 38.264901], color: 'red' },
            { coordinate: [127.197941, 38.103966], color: 'red' },
            { coordinate: [126.764465, 37.845892], color: 'red' },
            { coordinate: [126.642747, 37.770262], color: 'red' },
            { coordinate: [127.740489, 37.766012], color: 'red' },
            { coordinate: [127.797725, 37.751264], color: 'red' },
            { coordinate: [128.030626, 38.084725], color: 'red' },
                 

            // 닭

            { coordinate: [127.229455, 35.324125], color: 'orange' },
            { coordinate: [126.474708, 35.077821], color: 'orange' },
            { coordinate: [126.513727, 34.753912], color: 'orange' },
            { coordinate: [126.584764, 34.892232], color: 'orange' },
            { coordinate: [126.549651, 34.798209], color: 'orange' },
            { coordinate: [126.507408, 35.017809], color: 'orange' },
            { coordinate: [126.484330, 35.049810], color: 'orange' },
            { coordinate: [126.571701, 34.960341], color: 'orange' },
            { coordinate: [126.814986, 35.592403], color: 'orange' },
            { coordinate: [126.895579, 35.629445], color: 'orange' },
            { coordinate: [126.797055, 35.558635], color: 'orange' },
            { coordinate: [127.182460, 35.381335], color: 'orange' },

            //오리

            { coordinate: [126.766136, 35.584276], color: 'yellow' },
            { coordinate: [127.0087, 35.6654], color: 'yellow' },
            { coordinate: [126.912237, 34.724243], color: 'yellow' },
            { coordinate: [127.345507, 35.375741], color: 'yellow' },
            { coordinate: [126.479915, 35.468736], color: 'yellow' },
            { coordinate: [126.764989, 34.885649], color: 'yellow' },            
            { coordinate: [126.716835, 34.948711], color: 'yellow' },            
            { coordinate: [126.684567, 34.966221], color: 'yellow' },
            { coordinate: [127.091590, 34.733395], color: 'yellow' },
            { coordinate: [126.684375, 34.935504], color: 'yellow' },
            { coordinate: [126.726614, 34.964627], color: 'yellow' },
            { coordinate: [126.494911, 35.095583], color: 'yellow' },
            { coordinate: [126.545013, 34.395115], color: 'yellow' },
            { coordinate: [126.584357, 34.847114], color: 'yellow' },
            { coordinate: [126.426381, 34.875150], color: 'yellow' },
            { coordinate: [126.359730, 35.053545], color: 'yellow' },
            { coordinate: [127.160959, 35.248290], color: 'yellow' },
            { coordinate: [127.436804, 35.022738], color: 'yellow' },
            { coordinate: [126.558784, 34.893826], color: 'yellow' },
            { coordinate: [126.459718, 35.058231], color: 'yellow' },
            { coordinate: [126.577020, 34.925512], color: 'yellow' },
            { coordinate: [126.571760, 34.960479], color: 'yellow' },
            { coordinate: [127.369366, 34.801537], color: 'yellow' },
            { coordinate: [126.571800, 34.960259], color: 'yellow' },
            { coordinate: [126.911892, 34.723017], color: 'yellow' },

        ];

        var markerLayer = new ol.layer.Vector({
            source: new ol.source.Vector(),
        });

        markerData.forEach(function (marker) {
            var markerCoordinate = ol.proj.fromLonLat(marker.coordinate);

            var markerStyle = new ol.style.Style({
                image: new ol.style.Circle({
                    radius: 6,
                    fill: new ol.style.Fill({
                        color: marker.color,
                    }),
                }),
            });

            var markerFeature = new ol.Feature({
                geometry: new ol.geom.Point(markerCoordinate)
            });

            markerFeature.setStyle(markerStyle);

            markerLayer.getSource().addFeature(markerFeature);
        });

        map.addLayer(markerLayer);
