const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    multiArray: [
      ['中', '英', '法', '日', '韩'],
      ['中', '英', '法', '日', '韩']
    ],
    multiIndex: [0, 0, 0],
    active: 0,
    show: {
      middle: false
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log(options.active);
    let isIphoneX = app.globalData.isIphoneX;
    this.setData({
      isIphoneX: isIphoneX,
      active: options.active
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
  toggle(type) {
    this.setData({
      [`show.${type}`]: !this.data.show[type]
    });
  },
  onClickIcon() {
    this.toggle('middle');
  },
  bindMultiPickerChange(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      multiIndex: e.detail.value
    })
  },
  bindMultiPickerColumnChange(e) {
    console.log('修改的列为', e.detail.column, '，值为', e.detail.value)
    const data = {
      multiArray: this.data.multiArray,
      multiIndex: this.data.multiIndex
    }
    data.multiIndex[e.detail.column] = e.detail.value
    data.multiArray[1] = ['中', '英', '法', '日', '韩']
    console.log(data.multiIndex)
    this.setData(data)
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
  }
})