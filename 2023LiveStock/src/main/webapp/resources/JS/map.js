// 사용 예제

// *서비스 호출
function inintMap(){

param = {name:'livestock',

        serverUrl:'www.safemap.go.kr/sm/apis.do?apikey=[QXIDN3TM-QXID-QXID-QXID-QXIDN3TMTI]',

        layername:'A2SM_LVSTCKICTSD_NEW',

        styles:'A2SM_LVSTCKICTSD_NEW'};

var wmsLayer = new OpenLayers.Layer.WMS(param.name, param.serverUrl,

    {
    layers: 'A2SM_LVSTCKICTSD_NEW'+param.layername,
    styles:param.styles,
    format: 'image/png',
    exceptions:'text/xml',
    transparent: true},

    {
    isBaseLayer: false
    }
);

};