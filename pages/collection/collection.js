const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    wx.getSetting({
      success(res) {
        console.log(res.authSetting['scope.userInfo'])
        if (res.authSetting['scope.userInfo'] != true) {
          wx.showModal({
            content: '您还未进行微信授权，请您微信授权后再进行操作',
            showCancel: false,
            success: function(res) {
              if (res.confirm) {
                console.log('用户点击确定')
                wx.navigateBack({
                  delta: 1
                })
              }
            }
          });
        } else {
          wx.request({
            url: app.globalData.urlPath + '/Word/querywordwithcollection',
            data: {},
            method: 'GET',
            header: {
              'content-type': 'application/json',
              'Cookie': 'JSESSIONID=' + app.globalData.sessionid
            },
            success: function(res) {
              console.log(res.data.listCollectionWord)
              that.setData({
                list: res.data.listCollectionWord
              })
            }
          });
        }
      }
    })
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
  // ListTouch触摸开始
  ListTouchStart(e) {
    this.setData({
      ListTouchStart: e.touches[0].pageX
    })
  },

  // ListTouch计算方向
  ListTouchMove(e) {
    this.setData({
      ListTouchDirection: e.touches[0].pageX - this.data.ListTouchStart > 0 ? 'right' : 'left'
    })
  },

  // ListTouch计算滚动
  ListTouchEnd(e) {
    if (this.data.ListTouchDirection == 'left') {
      this.setData({
        modalName: e.currentTarget.dataset.target
      })
    } else {
      this.setData({
        modalName: null
      })
    }
    this.setData({
      ListTouchDirection: null
    })
  },
  onDeleteCollection:function(e){
    console.log(e.target.dataset.wordid)
    wx.request({
      url: app.globalData.urlPath + '/Word/modifywithcollection',
      data: {
        isColletion: 0,
        wordId: e.target.dataset.wordid
      },
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      success: function (res) {
        console.log(res.data)
      }
    })
  }
})