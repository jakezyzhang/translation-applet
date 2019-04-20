// pages/person/person.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    active: 0,
    nickName: '微信授权登录',
    avatarUrl: '../../package/icons/head.png',
    flag: undefined
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    that.setData({
      active: options.active
    })
    that.queryWxUserInfo();
    wx.getSetting({
      success(res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success(res) {
              console.log(res.encryptedData)
              // that.queryWxUserInfo();
              that.setData({
                nickName: res.userInfo.nickName,
                avatarUrl: res.userInfo.avatarUrl
              })
            }
          })
        }
      }
      // success: function(res) {
      //   if (res.authSetting['scope.userInfo']) {
      //     wx.getUserInfo({
      //       success: function(res) {
      //         //从数据库获取用户信息
      //         that.queryUsreInfo();
      //         //用户已经授权过
      //         wx.switchTab({
      //           url: '../translation/index'
      //         })
      //       }
      //     });
      //   }
      // }

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
  onChange(event) {
    console.log(event.detail);
    if (event.detail == 0) {
      wx.redirectTo({
        url: '../translation/index?active=' + event.detail,
      })
    }
    if (event.detail == 1) {
      wx.redirectTo({
        url: '../news/news?active=' + event.detail,
      })

    }
    if (event.detail == 2) {
      wx.redirectTo({
        url: '../person/person?active=' + event.detail,
      })
    }
  },
  bindGetUserInfo(e) {
    var that = this
    console.log('flag：' + app.globalData.flag)
    console.log('person：' + app.globalData.openid)
    if (e.detail.userInfo != null) {
      console.log(' ' + app.globalData.openid)
      that.setData({
        nickName: e.detail.userInfo.nickName,
        avatarUrl: e.detail.userInfo.avatarUrl,
      })
      wx.redirectTo({
        url: '../person/person?active=' + 2,
      })
      wx.getUserInfo({
        success(res) {
          console.log('encryptedData：' + res.encryptedData)
        }
      })
    }
    
  },
  queryWxUserInfo: function() {
    console.log(app.globalData.openid)
    wx.request({
      url: app.globalData.urlPath + '/WxUser/userbyopenid',
      data: {
        openId: app.globalData.openid
      },
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        app.globalData.flag = res.data.success
      }
    })

  },
})