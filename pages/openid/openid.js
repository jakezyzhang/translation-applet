// pages/openid/openid.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  formSubmit(e) {
    console.log(app.globalData.openid)
    var that = this
    // wx.login({
    //   success: function(res) {
    //     wx.request({
    //       url: app.globalData.urlPath + '/Word/getopenid',
    //       data: {
    //         appId: 'wx11b17040118611a9',
    //         secret: '26a9537756d7f125244e021b312afb19',
    //         code: res.code
    //       },
    //       method: 'GET',
    //       header: {
    //         'content-type': 'application/json',
    //         'Cookie':'code=' + res.code
    //       },
    //       success: function(res) {
    //         console.log(res.data)
    //       }
    //     })
    //   }
    // })
    wx.request({
      url: app.globalData.urlPath + '/WxInfo/getsessionid',
      header: {
        'content-type': 'application/json',
        'Cookie': 'JSESSIONID=' + app.globalData.sessionid
      },
      data: {},
      method: 'GET',
      success:function(res){
        console.log(res.data)
      }
    })
  },
})